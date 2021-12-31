package com.liquidforte.song.math.geometry;

import java.util.function.Function;
import java.util.function.Predicate;

public interface VectorSet<V extends Vector<V>> {
    V construct(int... components);

    default V getOrigin() {
        return construct();
    }

    default V construct(V v) {
        int[] components = new int[v.getDimensions()];
        for (int axis = 0; axis < v.getDimensions(); axis++) {
            components[axis] = v.getComponent(axis);
        }
        return construct(components);
    }

    default int getDimensions() {
        return getOrigin().getDimensions();
    }

    default VectorSet<V> constrain(Constrain<V> constraint) {
        return constraint.apply(this);
    }

    default VectorSet<V> offset(Offset<V> offset) {
        return offset.apply(this);
    }

    default VectorSet<V> map(Function<V, V> mapFn) {
        return components -> mapFn.apply(construct(components));
    }

    default VectorSet<V> filter(Predicate<V> filterFn) {
        return components -> {
            V result = construct(components);
            if (filterFn.test(result)) {
                return result;
            }
            return null;
        };
    }

    default VectorSet<V> add(V other) {
        return map(v -> v.add(other));
    }

    default VectorSet<V> scale(double scalar) {
        return map(v -> v.scale(scalar));
    }

    default VectorSet<V> subtract(V other) {
        return map(v -> v.subtract(other));
    }
}
