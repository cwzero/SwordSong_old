package com.liquidforte.song.math.geometry;

public interface Vector<V extends Vector<V>> {
    V add(V other);

    V invert();

    default V subtract(V other) {
        return add(other.invert());
    }
}
