package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.Constrain;

public record Size3D(int width, int height, int depth) implements Constrain<Point3D> {
    @Override
    public boolean match(Point3D p) {
        return p.x() >= 0 && p.x() < width &&
                p.y() >= 0 && p.y() < height &&
                p.z() >= 0 && p.z() < depth;
    }

    public PointSet3D getPoints() {
        return PointSpace3D.INSTANCE.constrain(this);
    }

    public static Size3D of(int width, int height, int depth) {
        return new Size3D(width, height, depth);
    }
}
