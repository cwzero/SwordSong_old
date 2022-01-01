package com.liquidforte.song.math.geometry;

import java.util.function.Function;
import java.util.function.Predicate;

public interface VectorSetOperations<V extends Vector, S extends VectorSet<V>> {
    VectorSetOperation<V, S, Function<V, V>> map();

    VectorSetOperation<V, S, Predicate<V>> filter();

    default VectorSetOperation<V, S, Offset<V>> offset() {
        return (set, offset) -> map().apply(set, offset);
    }

    default VectorSetOperation<V, S, Constrain<V>> constrain() {
        return (set, constraint) -> filter().apply(set, constraint);
    }
}
