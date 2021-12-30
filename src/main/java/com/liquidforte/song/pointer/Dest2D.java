package com.liquidforte.song.pointer;

import com.liquidforte.song.geometry.twod.Point2D;

public interface Dest2D<V> extends Source2D<V> {
    V set(int x, int y, V v);

    default V set(Point2D pos, V v) {
        return set(pos.x(), pos.y(), v);
    }

    default V set(Positional2D pos, V v) {
        return set(pos.getX(), pos.getY(), v);
    }
}
