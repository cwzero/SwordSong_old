package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.Vector;

public interface Vector2D<V extends Vector2D<V>> extends Vector<V> {
    @Override
    default int getDimensions() {
        return 2;
    }
}
