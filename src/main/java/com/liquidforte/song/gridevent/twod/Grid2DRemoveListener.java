package com.liquidforte.song.gridevent.twod;

import com.liquidforte.song.geometry.twod.Grid2D;

public interface Grid2DRemoveListener<G extends Grid2D<G, V>, V> extends Grid2DPointListener<G, V> {
    void handleRemoveEvent(Grid2DRemoveEvent<G, V> event);

    default boolean filterRemoveEvent(Grid2DRemoveEvent<G, V> event) {
        return true;
    }

    @Override
    default void handlePointEvent(Grid2DPointEvent<G, V> event) {
        if (event instanceof Grid2DRemoveEvent<G, V> e) {
            handleRemoveEvent(e);
        }
    }

    @Override
    default boolean filterPointEvent(Grid2DPointEvent<G, V> event) {
        if (event instanceof Grid2DRemoveEvent<G, V> e) {
            return filterRemoveEvent(e);
        }
        return false;
    }
}
