package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.VectorSet;

public interface VectorSet2D<V extends Vector2D> extends VectorSet<V> {
    VectorSet2D<V> offset(int x, int y);

    VectorSet2D<V> constrain(int width, int height);
}
