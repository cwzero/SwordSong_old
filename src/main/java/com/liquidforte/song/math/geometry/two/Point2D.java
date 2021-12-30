package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.Point;

public record Point2D(int x, int y) implements Point<Point2D>, Vector2D<Point2D> {
    @Override
    public Point2D add(Point2D other) {
        return new Point2D(this.x + other.x, this.y + other.y);
    }

    @Override
    public Point2D invert() {
        return new Point2D(-x, -y);
    }
}
