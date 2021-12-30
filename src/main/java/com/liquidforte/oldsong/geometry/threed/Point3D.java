package com.liquidforte.oldsong.geometry.threed;

import com.liquidforte.oldsong.geometry.Point;
import com.liquidforte.oldsong.pointer.Positional3D;

public record Point3D(int x, int y, int z) implements Point, Vector3D, Positional3D {
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public Point3D getPosition() {
        return this;
    }

    public Point3D add(int x, int y, int z) {
        return new Point3D(this.x + x, this.y + y, this.z + z);
    }
}
