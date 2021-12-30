package com.liquidforte.song.gridevent.twod;

import com.liquidforte.song.geometry.twod.Grid2D;

public interface Grid2DPointListener<G extends Grid2D<G, V>, V> extends Grid2DListener<G, V> {
    void handlePointEvent(Grid2DPointEvent<G, V> event);

    default boolean filterPointEvent(Grid2DPointEvent<G, V> event) {
        return true;
    }

    @Override
    default void handleEvent(Grid2DEvent<G, V> event) {
        if (event instanceof Grid2DPointEvent<G, V> e) {
            handlePointEvent(e);
        }
    }

    @Override
    default boolean filterEvent(Grid2DEvent<G, V> event) {
        if (event instanceof Grid2DPointEvent<G, V> e) {
            return filterPointEvent(e);
        } else {
            return false;
        }
    }
}
