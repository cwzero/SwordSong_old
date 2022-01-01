package com.liquidforte.song.math.geometry;

public interface VectorOperations<V extends Vector> {
    VectorOperation<V, V, V> add();

    VectorOperation<V, Double, V> scale();

    VectorOperation<V, V, Double> dot();

    default VectorOperation<V, V, V> subtract() {
        return (a, b) -> add().apply(a, scale().apply(b, -1.0));
    }
}
