package com.liquidforte.song.math.geometry;

@FunctionalInterface
public interface Offset<V extends Vector<V>> extends VectorOperation<V> {
    V getOffset();

    @Override
    default V apply(V v) {
        return v.add(getOffset());
    }
}
