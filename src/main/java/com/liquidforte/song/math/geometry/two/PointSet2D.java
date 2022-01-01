package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.Constrain;
import com.liquidforte.song.math.geometry.Offset;
import com.liquidforte.song.math.geometry.PointSet;
import com.liquidforte.song.math.geometry.VectorOperation;

import java.util.function.Function;
import java.util.function.Predicate;

public interface PointSet2D extends VectorSet2D<Point2D>, PointSet<Point2D> {
    default Point2D construct(int x, int y) {
        return construct(new Point2D(x, y));
    }

    @Override
    default VectorOperation<Point2D, Point2D, Point2D> subtract() {
        return Point2D::subtract;
    }

    @Override
    default VectorOperation<Point2D, Point2D, Point2D> add() {
        return Point2D::add;
    }

    @Override
    default VectorOperation<Point2D, Double, Point2D> scale() {
        return Point2D::scale;
    }

    @Override
    default VectorOperation<Point2D, Point2D, Double> dot() {
        return Point2D::dot;
    }

    @Override
    default PointSet2D map(Function<Point2D, Point2D> mapFn) {
        return input -> mapFn.apply(construct(input));
    }

    @Override
    default PointSet2D filter(Predicate<Point2D> filterFn) {
        return input -> {
            if (filterFn.test(input)) {
                return construct(input);
            }
            return null;
        };
    }
}
