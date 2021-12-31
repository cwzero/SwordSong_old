package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.PointSet;

import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
public interface PointSet3D extends VectorSet3D<PointSet3D, Point3D>, PointSet<PointSet3D, Point3D> {
    @Override
    default PointSet3D map(Function<Point3D, Point3D> mapFn) {
        return components -> mapFn.apply(construct(components));
    }

    @Override
    default PointSet3D filter(Predicate<Point3D> filterFn) {
        return components -> {
            Point3D p = construct(components);
            if (filterFn.test(p)) {
                return p;
            }
            return null;
        };
    }
}
