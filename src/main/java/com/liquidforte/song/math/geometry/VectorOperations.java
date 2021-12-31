package com.liquidforte.song.math.geometry;

import java.util.function.BiFunction;

public interface VectorOperations<V extends Vector<V>> {
    default BiFunction<V, V, V> add() {
        return Vector::add;
    }

    default BiFunction<V, Double, V> scale() {
        return Vector::scale;
    }

    default BiFunction<V, V, Double> dot() {
        return Vector::dot;
    }

    default BiFunction<V, V, V> subtract() {
        return Vector::subtract;
    }
}
