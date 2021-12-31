package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.Point;

public record Point3D(int x, int y, int z) implements Vector3D<Point3D>, Point<Point3D> {
    @Override
    public Point3D add(Point3D other) {
        return new Point3D(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    @Override
    public Point3D scale(double scalar) {
        return new Point3D((int) (this.x * scalar), (int) (this.y * scalar), (int) (this.z * scalar));
    }

    @Override
    public double dot(Point3D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    @Override
    public int getComponent(int axis) {
        return switch (axis) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            default -> throw new RuntimeException("Tried to get invalid axis index " + axis + " from a Point3D.");
        };
    }

    public static Point3D of(int... components) {
        if (components.length == 0) {
            return origin();
        } else if (components.length == 3) {
            return of(components[0], components[1], components[2]);
        } else {
            return null;
        }
    }

    public static Point3D of(int x, int y, int z) {
        return new Point3D(x, y, z);
    }

    public static Point3D origin() {
        return of(0, 0, 0);
    }
}
