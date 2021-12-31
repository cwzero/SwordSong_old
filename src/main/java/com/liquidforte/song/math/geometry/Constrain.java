package com.liquidforte.song.math.geometry;

@FunctionalInterface
public interface Constrain<V extends Vector<V>> extends VectorOperation<V> {
    boolean match(V v);

    @Override
    default V apply(V v) {
        if (match(v)) {
            return v;
        }
        return null;
    }
}
