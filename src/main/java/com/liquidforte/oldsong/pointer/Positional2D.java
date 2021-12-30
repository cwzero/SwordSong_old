package com.liquidforte.oldsong.pointer;

import com.liquidforte.oldsong.geometry.twod.Point2D;

public interface Positional2D {
    default int getX() {
        return getPosition().x();
    }

    default int getY() {
        return getPosition().y();
    }

    Point2D getPosition();
}
