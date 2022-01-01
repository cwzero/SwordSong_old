package com.liquidforte.song.math.geometry;

import java.util.function.Function;
import java.util.function.Predicate;

public interface VectorSet<V extends Vector> extends VectorOperations<V> {
    V construct(V input);

    default V getOrigin() {
        return construct(null);
    }

    VectorSet<V> map(Function<V, V> mapFn);

    default VectorSet<V> offset(Offset<V> offset) {
        return map(offset);
    }

    VectorSet<V> filter(Predicate<V> filterFn);

    default VectorSet<V> constrain(Constrain<V> constrain) {
        return filter(constrain);
    }
}
