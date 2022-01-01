package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.VectorSet;

public interface VectorSet3D<V extends Vector3D> extends VectorSet<V> {
    VectorSet3D<V> offset(int x, int y, int z);

    VectorSet3D<V> constrain(int width, int height, int depth);
}
