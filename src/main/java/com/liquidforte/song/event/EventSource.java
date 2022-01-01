package com.liquidforte.song.event;

public interface EventSource {
    default <L extends EventListener> void addListener(L listener) {
        addListener(EventListener.class, listener);
    }

    <T extends EventListener, L extends T> void addListener(Class<T> listenerClass, L listener);

    default <L extends EventListener> void removeListener(L listener) {
        removeListener(EventListener.class, listener);
    }

    <T extends EventListener, L extends T> void removeListener(Class<T> listenerClass, L listener);
}
