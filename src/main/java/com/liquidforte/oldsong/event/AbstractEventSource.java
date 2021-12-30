package com.liquidforte.oldsong.event;

import javax.swing.event.EventListenerList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public abstract class AbstractEventSource implements EventSource {
    private final EventListenerList listeners = new EventListenerList();

    @Override
    public <T extends EventListener, L extends T> void addListener(Class<T> listenerClass, L listener) {
        listeners.add(listenerClass, listener);
    }

    @Override
    public <T extends EventListener, L extends T> void removeListener(Class<T> listenerClass, L listener) {
        listeners.remove(listenerClass, listener);
    }

    protected <T extends EventListener, E> void fireEvent(Class<T> listenerClass, BiPredicate<T, E> filter, BiConsumer<T, E> handler, E event) {
        Executor executor = ForkJoinPool.commonPool();
        Arrays.stream(listeners.getListeners(listenerClass))
                .filter(it -> filter.test(it, event))
                .forEach(it -> executor
                        .execute(() -> handler.accept(it, event)));
    }
}
