package com.liquidforte.song.math.geometry;

import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings("unchecked")
public interface VectorSet<S extends VectorSet<S, V>, V extends Vector<V>> {
    V construct(int... components);

    default V getOrigin() {
        return construct();
    }

    V construct(V v);

    default int getDimensions() {
        return getOrigin().getDimensions();
    }

    default S constrain(Constrain<V> constraint) {
        return map(constraint);
    }

    default S offset(Offset<V> offset) {
        return map(offset);
    }

    S map(Function<V, V> mapFn);

    S filter(Predicate<V> filterFn);

    default S add(V other) {
        return map(v -> v.add(other));
    }

    default S scale(double scalar) {
        return map(v -> v.scale(scalar));
    }

    default S subtract(V other) {
        return map(v -> v.subtract(other));
    }
}
