package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.Offset;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Vector;

public record Point2D(int x, int y) implements Vector2D, Point, Offset<Point2D> {
    public static final PointSet2D space = Point2D::of;

    public static Point2D of(Point2D other) {
        if (other == null) return null;
        return new Point2D(other.x, other.y);
    }

    public Point2D(Point2D other) {
        this(other.x, other.y);
    }

    @Override
    public Point2D add(Vector other) {
        if (other instanceof Point2D p) {
            return add(p);
        }
        return null;
    }

    public Point2D add(Point2D other) {
        return new Point2D(this.x + other.x, this.y + other.y);
    }

    @Override
    public Point2D scale(double scalar) {
        return new Point2D((int) (this.x * scalar), (int) (this.y * scalar));
    }

    @Override
    public Point2D subtract(Vector other) {
        if (other instanceof Point2D p) {
            return subtract(p);
        }
        return null;
    }

    public Point2D subtract(Point2D p) {
        return new Point2D(this.x - p.x, this.y - p.y);
    }

    @Override
    public double dot(Vector other) {
        if (other instanceof Point2D p) {
            return dot(p);
        }
        return 0;
    }

    public double dot(Point2D p) {
        return this.x * p.x + this.x * p.y;
    }

    @Override
    public Point2D apply(Point2D target) {
        if (target == null) return null;
        return new Point2D(target.x + this.x, target.y + this.y);
    }
}
