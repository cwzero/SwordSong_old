package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.PointSet;

public interface PointSet2D<S extends PointSet2D<S>> extends VectorSet2D<S, Point2D>, PointSet<S, Point2D> {
    default S constrain(int width, int height) {
        return constrain(Size2D.of(width, height));
    }

    default S offset(int x, int y) {
        return offset(Point2D.of(x, y));
    }

    @Override
    default Point2D construct(int... components) {
        return Point2D.of(components);
    }

    @Override
    default Point2D construct(Point2D p) {
        if (p == null) {
            return null;
        }
        return construct(p.x(), p.y());
    }
}
