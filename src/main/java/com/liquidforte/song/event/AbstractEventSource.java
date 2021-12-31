package com.liquidforte.song.event;

import javax.swing.event.EventListenerList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public abstract class AbstractEventSource implements EventSource {
    private final EventListenerList listeners = new EventListenerList();

    protected <T extends EventListener, E> E fireEvent(Class<T> listenerClass, BiConsumer<T, E> handler, E event) {
        return fireEvent(listenerClass, EventListener::filterEvent, handler, event);
    }

    protected <T extends EventListener, E> E fireEvent(Class<T> listenerClass, BiPredicate<T, E> filter, BiConsumer<T, E> handler, E event) {
        Executor executor = ForkJoinPool.commonPool();
        Arrays.stream(listeners.getListeners(listenerClass))
                .filter(it -> filter.test(it, event))
                .forEach(it -> executor
                        .execute(() -> handler.accept(it, event)));
        return event;
    }

    @Override
    public <T extends EventListener, L extends T> void addListener(Class<T> listenerClass, L listener) {
        listeners.add(listenerClass, listener);
    }

    @Override
    public <T extends EventListener, L extends T> void removeListener(Class<T> listenerClass, L listener) {
        listeners.remove(listenerClass, listener);
    }
}
