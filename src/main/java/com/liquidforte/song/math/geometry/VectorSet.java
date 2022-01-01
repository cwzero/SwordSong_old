package com.liquidforte.song.math.geometry;

import java.util.function.Function;
import java.util.function.Predicate;

public interface VectorSet<V extends Vector> extends VectorOperations<V> {
    V construct(V input);

    VectorSet<V> map(Function<V, V> mapFn);

    VectorSet<V> filter(Predicate<V> filterFn);
}
