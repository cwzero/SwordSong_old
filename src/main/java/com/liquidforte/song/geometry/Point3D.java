package com.liquidforte.song.geometry;

import com.liquidforte.song.pointer.Positional3D;

public record Point3D(int x, int y, int z) implements Positional3D {
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
}
