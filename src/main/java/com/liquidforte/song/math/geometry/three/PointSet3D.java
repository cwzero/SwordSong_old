package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.PointSet;
import com.liquidforte.song.math.geometry.VectorOperation;

import java.util.function.Function;
import java.util.function.Predicate;

public interface PointSet3D extends VectorSet3D<Point3D>, PointSet<Point3D> {
    default Point3D construct(int x, int y, int z) {
        return construct(new Point3D(x, y, z));
    }

    @Override
    default VectorOperation<Point3D, Point3D, Point3D> add() {
        return Point3D::add;
    }

    @Override
    default VectorOperation<Point3D, Double, Point3D> scale() {
        return Point3D::scale;
    }

    @Override
    default VectorOperation<Point3D, Point3D, Double> dot() {
        return Point3D::dot;
    }

    @Override
    default PointSet3D map(Function<Point3D, Point3D> mapFn) {
        return input -> mapFn.apply(construct(input));
    }

    @Override
    default PointSet3D filter(Predicate<Point3D> filterFn) {
        return input -> {
            if (filterFn.test(input)) {
                return construct(input);
            }
            return null;
        };
    }
}
