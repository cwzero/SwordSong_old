package com.liquidforte.song.math.geometry.two;

public class PointSet2D implements VectorSet2D<Point2D> {
    @Override
    public Point2D construct(int... components) {
        return Point2D.of(components);
    }

    @Override
    public Point2D getOrigin() {
        return new Point2D(0, 0);
    }

    @Override
    public Point2D construct(Point2D point2D) {
        return new Point2D(point2D.x(), point2D.y());
    }
}
