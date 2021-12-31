package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.PointSpace;

public final class PointSpace3D implements PointSet3D, VectorSpace3D<Point3D>, PointSpace<Point3D> {
    public static PointSpace3D INSTANCE = new PointSpace3D();

    private PointSpace3D() {
    }

    @Override
    public Point3D construct(int... components) {
        return Point3D.of(components);
    }
}
