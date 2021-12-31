package com.liquidforte.song.math.geometry;

import java.util.function.Function;

@FunctionalInterface
public interface VectorOperation< V extends Vector<V>> extends Function<V, V> {
    V apply(V v);
}
