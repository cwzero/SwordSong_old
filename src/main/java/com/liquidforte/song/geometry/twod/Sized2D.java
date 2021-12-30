package com.liquidforte.song.geometry.twod;

public interface Sized2D {
    default int getWidth() {
        return getSize().width();
    }

    default int getHeight() {
        return getSize().height();
    }

    Size2D getSize();
}
