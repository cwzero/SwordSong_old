package com.liquidforte.song.pointer;

import com.liquidforte.song.geometry.twod.Point2D;

public interface Positional2D {
    default int getX() {
        return getPosition().x();
    }

    default int getY() {
        return getPosition().y();
    }

    Point2D getPosition();
}
