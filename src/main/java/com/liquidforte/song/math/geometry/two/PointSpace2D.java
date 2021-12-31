package com.liquidforte.song.math.geometry.two;

public final class PointSpace2D extends PointSet2D implements VectorSpace2D<Point2D> {
    public static final PointSpace2D INSTANCE = new PointSpace2D();

    private PointSpace2D() {}
}
