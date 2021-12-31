package com.liquidforte.song.math.geometry;

import java.util.function.Function;

@FunctionalInterface
public interface VectorOperation<V extends Vector<V>> extends Function<VectorSet<V>, VectorSet<V>> {
    V apply(V v);

    @Override
    default VectorSet<V> apply(VectorSet<V> vs) {
        return vs.map(this::apply);
    }
}
