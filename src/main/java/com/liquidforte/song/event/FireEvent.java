package com.liquidforte.song.event;

import java.util.EventListener;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public interface FireEvent {
    <T extends EventListener, E> void fireEvent(Class<T> listenerClass, BiPredicate<T, E> filter, BiConsumer<T, E> handler, E event);
}
