package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.VectorSet;

public interface VectorSet2D<V extends Vector2D<V>> extends VectorSet<V> {
    @Override
    default int getDimensions() {
        return 2;
    }
}
