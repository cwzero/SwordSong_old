package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.PointSpace;
import com.liquidforte.song.math.geometry.VectorSetOperation;

import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
public interface PointSpace2D extends PointSet2D, VectorSpace2D<Point2D, PointSet2D>, PointSpace<Point2D, PointSet2D> {
    @Override
    default VectorSetOperation<Point2D, PointSet2D, Function<Point2D, Point2D>> map() {
        return (set, mapFn) -> input -> this.construct(mapFn.apply(input));
    }

    @Override
    default VectorSetOperation<Point2D, PointSet2D, Predicate<Point2D>> filter() {
        return (set, filterFn) -> input -> {
            var p = this.construct(input);
            if (filterFn.test(p)) {
                return p;
            }
            return null;
        };
    }
}
