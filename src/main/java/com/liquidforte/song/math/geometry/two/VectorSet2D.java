package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.Constrain;
import com.liquidforte.song.math.geometry.Offset;
import com.liquidforte.song.math.geometry.VectorSet;

import java.util.function.Function;
import java.util.function.Predicate;

public interface VectorSet2D<V extends Vector2D<V>> extends VectorSet<V> {
    @Override
    default V getOrigin() {
        return construct(0, 0);
    }

    @Override
    default V construct(V v) {
        return construct(v.getComponent(0), v.getComponent(1));
    }

    @Override
    default int getDimensions() {
        return 2;
    }

    @Override
    default VectorSet2D<V> constrain(Constrain<V> constraint) {
        return map(constraint::apply);
    }

    @Override
    default VectorSet2D<V> offset(Offset<V> offset) {
        return map(offset::apply);
    }

    @Override
    default VectorSet2D<V> map(Function<V, V> mapFn) {
        return components -> mapFn.apply(construct(components));
    }

    @Override
    default VectorSet2D<V> filter(Predicate<V> filterFn) {
        return components -> {
            V result = construct(components);
            if (filterFn.test(result)) {
                return result;
            }
            return null;
        };
    }

    @Override
    default VectorSet2D<V> add(V other) {
        return map(v -> v.add(other));
    }

    @Override
    default VectorSet2D<V> scale(double scalar) {
        return map(v -> v.scale(scalar));
    }

    @Override
    default VectorSet2D<V> subtract(V other) {
        return map(v -> v.subtract(other));
    }
}
