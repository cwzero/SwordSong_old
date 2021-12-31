package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.VectorSet;

public interface VectorSet2D<S extends VectorSet2D<S, V>, V extends Vector2D<V>> extends VectorSet<S, V> {
    @Override
    default V getOrigin() {
        return construct(0, 0);
    }

    @Override
    default V construct(V v) {
        return construct(v.getComponent(0), v.getComponent(1));
    }

    @Override
    default int getDimensions() {
        return 2;
    }
}
