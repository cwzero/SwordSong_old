package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.VectorSet;

public interface VectorSet3D<S extends VectorSet3D<S, V>, V extends Vector3D<V>> extends VectorSet<S, V> {
    @Override
    default V getOrigin() {
        return construct(0, 0, 0);
    }

    @Override
    default V construct(V v) {
        return construct(v.getComponent(0), v.getComponent(1), v.getComponent(2));
    }

    @Override
    default int getDimensions() {
        return 3;
    }
}
