package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.Offset;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Vector;

public record Point3D(int x, int y, int z) implements Vector3D, Point, Offset<Point3D> {
    public Point3D(Point3D other) {
        this(other.x, other.y, other.z);
    }

    @Override
    public Point3D add(Vector other) {
        if (other instanceof Point3D p) {
            return add(p);
        }
        return null;
    }

    public Point3D add(Point3D p) {
        return new Point3D(this.x + p.x, this.y + p.y, this.z + p.z);
    }

    @Override
    public Point3D scale(double scalar) {
        return new Point3D((int) (this.x * scalar), (int) (this.y * scalar), (int) (this.z * scalar));
    }

    @Override
    public double dot(Vector other) {
        if (other instanceof Point3D p) {
            return dot(p);
        }
        return 0;
    }

    @Override
    public Point3D subtract(Vector other) {
        if (other instanceof Point3D p) {
            return subtract(p);
        }
        return null;
    }

    public Point3D subtract(Point3D p) {
        return new Point3D(this.x - p.x, this.y - p.y, this.z - p.z);
    }


    public double dot(Point3D p) {
        return this.x * p.x + this.y * p.y + this.z * p.z;
    }

    @Override
    public Point3D apply(Point3D target) {
        return add(target);
    }
}
