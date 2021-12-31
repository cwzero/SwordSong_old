package com.liquidforte.song.math.geometry.two;

public record Point2D(int x, int y) implements Vector2D<Point2D> {
    @Override
    public Point2D add(Point2D other) {
        return new Point2D(this.x + other.x, this.y + other.y);
    }

    @Override
    public Point2D scale(double scalar) {
        return new Point2D((int) (this.x * scalar), (int) (this.y * scalar));
    }

    @Override
    public double dot(Point2D other) {
        return this.x * other.x + this.y * other.y;
    }

    @Override
    public int getComponent(int axis) {
        return switch (axis) {
            case 0 -> x;
            case 1 -> y;
            default -> throw new RuntimeException("Tried to get axis index " + axis + " from a Point2D.");
        };
    }

    public static Point2D of(int... components) {
        if (components.length == 2) {
            return of(components[0], components[1]);
        } else if (components.length == 1) {
            return of(components[0], 0);
        } else if (components.length == 0) {
            return of(0, 0);
        }
        return null;
    }

    public static Point2D of(int x, int y) {
        return new Point2D(x, y);
    }
}
