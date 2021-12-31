package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.PointSpace;

import java.util.function.Function;
import java.util.function.Predicate;

public class PointSpace2D implements PointSet2D<PointSpace2D>, VectorSpace2D<PointSpace2D, Point2D>, PointSpace<PointSpace2D, Point2D> {
    public static final PointSpace2D INSTANCE = new PointSpace2D();

    private PointSpace2D() {
    }

    @Override
    public Point2D construct(int... components) {
        return Point2D.of(components);
    }

    @Override
    public PointSpace2D map(Function<Point2D, Point2D> mapFn) {
        return new PointSpace2D() {
            @Override
            public Point2D construct(int... components) {
                return mapFn.apply(super.construct(components));
            }
        };
    }

    @Override
    public PointSpace2D filter(Predicate<Point2D> filterFn) {
        return new PointSpace2D() {
            @Override
            public Point2D construct(int... components) {
                Point2D p = super.construct(components);
                if (filterFn.test(p)) {
                    return p;
                }
                return null;
            }
        };
    }
}
