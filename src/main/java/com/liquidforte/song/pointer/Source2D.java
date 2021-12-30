package com.liquidforte.song.pointer;

import com.liquidforte.song.geometry.twod.Point2D;

public interface Source2D<V> {
    V get(int x, int y);

    default Pointer2D<V> getPointer(int x, int y) {
        return getPointer(new Point2D(x, y));
    }

    Pointer2D<V> getPointer(Point2D pos);

    default V get(Point2D pos) {
        return get(pos.x(), pos.y());
    }

    default V get(Positional2D target) {
        return get(target.getX(), target.getY());
    }
}
