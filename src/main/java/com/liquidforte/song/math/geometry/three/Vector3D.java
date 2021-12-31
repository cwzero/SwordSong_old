package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.Vector;

public interface Vector3D<V extends Vector3D<V>> extends Vector<V> {
    @Override
    default int getDimensions() {
        return 3;
    }
}
