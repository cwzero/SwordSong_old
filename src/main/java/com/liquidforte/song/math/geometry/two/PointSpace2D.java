package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.PointSpace;

public final class PointSpace2D implements PointSet2D, VectorSpace2D<Point2D>, PointSpace<Point2D> {
    public static final PointSpace2D INSTANCE = new PointSpace2D();

    private PointSpace2D() {
    }

    @Override
    public Point2D construct(int... components) {
        return Point2D.of(components);
    }
}
