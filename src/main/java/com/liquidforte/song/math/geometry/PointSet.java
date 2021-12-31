package com.liquidforte.song.math.geometry;

import java.util.function.Function;
import java.util.function.Predicate;

public interface PointSet<P extends Point<P>> extends VectorSet<P> {
    @Override
    default PointSet<P> constrain(Constrain<P> constraint) {
        return map(constraint::apply);
    }

    @Override
    default PointSet<P> offset(Offset<P> offset) {
        return map(offset::apply);
    }

    @Override
    default PointSet<P> map(Function<P, P> mapFn) {
        return components -> mapFn.apply(construct(components));
    }

    @Override
    default PointSet<P> filter(Predicate<P> filterFn) {
        return components -> {
            P result = construct(components);
            if (filterFn.test(result)) {
                return result;
            }
            return null;
        };
    }

    @Override
    default PointSet<P> add(P other) {
        return map(v -> v.add(other));
    }

    @Override
    default PointSet<P> scale(double scalar) {
        return map(p -> p.scale(scalar));
    }

    @Override
    default PointSet<P> subtract(P other) {
        return map(p -> p.subtract(other));
    }
}
