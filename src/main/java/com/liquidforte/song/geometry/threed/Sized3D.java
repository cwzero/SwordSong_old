package com.liquidforte.song.geometry.threed;

import com.liquidforte.song.geometry.threed.Size3D;

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
