package com.liquidforte.oldsong.pointer;

import com.liquidforte.oldsong.geometry.threed.Point3D;

public interface Positional3D {
    default int getX() {
        return getPosition().x();
    }

    default int getY() {
        return getPosition().y();
    }

    default int getZ() {
        return getPosition().z();
    }

    Point3D getPosition();
}
