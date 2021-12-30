package com.liquidforte.song.gridevent.twod;

import com.liquidforte.song.geometry.Grid2D;

public interface Grid2DAddListener<G extends Grid2D<G, V>, V> extends Grid2DPointListener<G, V> {
    void handleAddEvent(Grid2DAddEvent<G, V> event);

    default boolean filterAddEvent(Grid2DAddEvent<G, V> event) {
        return true;
    }

    @Override
    default void handlePointEvent(Grid2DPointEvent<G, V> event) {
        if (event instanceof Grid2DAddEvent<G, V> e) {
            handleAddEvent(e);
        }
    }

    @Override
    default boolean filterPointEvent(Grid2DPointEvent<G, V> event) {
        if (event instanceof Grid2DAddEvent<G, V> e) {
            return filterAddEvent(e);
        }
        return false;
    }
}
