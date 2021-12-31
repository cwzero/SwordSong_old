package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.Constrain;

public record Size2D(int width, int height) implements Constrain<Point2D> {
    @Override
    public boolean match(Point2D p) {
        return p.x() >= 0 && p.x() < width &&
                p.y() >= 0 && p.y() < height;
    }

    public PointSet2D getPoints() {
        return PointSpace2D.INSTANCE.constrain(this);
    }

    public static Size2D of(int width, int height) {
        return new Size2D(width, height);
    }
}
