package com.liquidforte.song.geometry;

import com.liquidforte.song.pointer.Positional2D;

public record Point2D(int x, int y) implements Positional2D {
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Point2D getPosition() {
        return this;
    }
}
