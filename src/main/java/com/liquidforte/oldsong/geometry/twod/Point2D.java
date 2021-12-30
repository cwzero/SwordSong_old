package com.liquidforte.oldsong.geometry.twod;

import com.liquidforte.oldsong.geometry.Point;
import com.liquidforte.oldsong.pointer.Positional2D;

public record Point2D(int x, int y) implements Point, Vector2D, Positional2D {
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
