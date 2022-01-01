package com.liquidforte.song.event;

import javax.swing.event.EventListenerList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public abstract class AbstractEventSource implements EventSource {
    private final EventListenerList listeners = new EventListenerList();

    public <E> E fireEvent(E event) {
        return fireEvent(EventListener.class, event);
    }

    public <T extends EventListener, E> E fireEvent(Class<T> listenerClass, E event) {
        return fireEvent(listenerClass, EventListener::handleEvent, event);
    }

    public <T extends EventListener, E> E fireEvent(Class<T> listenerClass, BiConsumer<T, E> handler, E event) {
        return fireEvent(listenerClass, EventListener::filterEvent, handler, event);
    }

    public <T extends EventListener, E> E fireEvent(Class<T> listenerClass, BiPredicate<T, E> filter, BiConsumer<T, E> handler, E event) {
        Executor executor = ForkJoinPool.commonPool();
        Arrays.stream(listeners.getListeners(listenerClass))
                .filter(it -> filter.test(it, event))
                .forEach(it -> executor
                        .execute(() -> handler.accept(it, event)));
        return event;
    }

    public <T extends EventListener> void addListener(T listener) {
        addListener(EventListener.class, listener);
    }

    @Override
    public <T extends EventListener, L extends T> void addListener(Class<T> listenerClass, L listener) {
        listeners.add(listenerClass, listener);
    }

    public <T extends EventListener> void removeListener(T listener) {
        removeListener(EventListener.class, listener);
    }

    @Override
    public <T extends EventListener, L extends T> void removeListener(Class<T> listenerClass, L listener) {
        listeners.remove(listenerClass, listener);
    }
}
