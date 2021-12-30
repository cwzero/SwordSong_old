package com.liquidforte.oldsong.geometry.threed;

public interface Sized3D {
    default int getWidth() {
        return getSize().width();
    }

    default int getHeight() {
        return getSize().height();
    }

    default int getDepth() {
        return getSize().depth();
    }

    Size3D getSize();
}
