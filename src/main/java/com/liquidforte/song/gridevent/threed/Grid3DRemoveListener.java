package com.liquidforte.song.gridevent.threed;

import com.liquidforte.song.geometry.Grid3D;

public interface Grid3DRemoveListener<G extends Grid3D<G, V>, V> extends Grid3DPointListener<G, V> {
    void handleRemoveEvent(Grid3DRemoveEvent<G, V> event);

    default boolean filterRemoveEvent(Grid3DRemoveEvent<G, V> event) {
        return true;
    }

    @Override
    default void handlePointEvent(Grid3DPointEvent<G, V> event) {
        if (event instanceof Grid3DRemoveEvent<G, V> e) {
            handleRemoveEvent(e);
        }
    }

    @Override
    default boolean filterPointEvent(Grid3DPointEvent<G, V> event) {
        if (event instanceof Grid3DRemoveEvent<G, V> e) {
            return filterRemoveEvent(e);
        }
        return false;
    }
}
