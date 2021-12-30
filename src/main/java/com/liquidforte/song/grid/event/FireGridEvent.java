package com.liquidforte.song.grid.event;

import com.liquidforte.song.math.geometry.Point;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public interface FireGridEvent<P extends Point, V> {
    <T extends GridListener<P, V>, E extends GridEvent<P, V>> E fireGridEvent(Class<T> listenerClass, BiPredicate<T, E> filter, BiConsumer<T, E> handler, E event);
}
