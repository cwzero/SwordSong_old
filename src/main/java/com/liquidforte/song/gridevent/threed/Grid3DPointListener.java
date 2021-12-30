package com.liquidforte.song.gridevent.threed;

import com.liquidforte.song.geometry.Grid3D;

public interface Grid3DPointListener<G extends Grid3D<G, V>, V> extends Grid3DListener<G, V> {
    void handlePointEvent(Grid3DPointEvent<G, V> event);

    default boolean filterPointEvent(Grid3DPointEvent<G, V> event) {
        return true;
    }

    @Override
    default void handleEvent(Grid3DEvent<G, V> event) {
        if (event instanceof Grid3DPointEvent<G, V> e) {
            handlePointEvent(e);
        }
    }

    @Override
    default boolean filterEvent(Grid3DEvent<G, V> event) {
        if (event instanceof Grid3DPointEvent<G, V> e) {
            return filterPointEvent(e);
        }
        return false;
    }
}
