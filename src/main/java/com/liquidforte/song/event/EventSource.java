package com.liquidforte.song.event;

public interface EventSource {
    <T extends EventListener, L extends T> void addListener(Class<T> listenerClass, L listener);

    <T extends EventListener, L extends T> void removeListener(Class<T> listenerClass, L listener);
}
