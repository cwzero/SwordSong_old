package com.liquidforte.song.gridevent.threed;

import com.liquidforte.song.geometry.Grid3D;

public interface Grid3DAddListener<G extends Grid3D<G, V>, V> extends Grid3DPointListener<G, V> {
    void handleAddEvent(Grid3DAddEvent<G, V> event);

    default boolean filterAddEvent(Grid3DAddEvent<G, V> event) {
        return true;
    }

    @Override
    default void handlePointEvent(Grid3DPointEvent<G, V> event) {
        if (event instanceof Grid3DAddEvent<G, V> e) {
            handleAddEvent(e);
        }
    }

    @Override
    default boolean filterPointEvent(Grid3DPointEvent<G, V> event) {
        if (event instanceof Grid3DAddEvent<G, V> e) {
            return filterAddEvent(e);
        }
        return false;
    }
}
