package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.Constrain;

public record Size2D(int width, int height) implements Constrain<Point2D> {
    @Override
    public boolean test(Point2D p) {
        return p.x() >= 0 && p.x() < width &&
                p.y() >= 0 && p.y() < height;
    }
}
