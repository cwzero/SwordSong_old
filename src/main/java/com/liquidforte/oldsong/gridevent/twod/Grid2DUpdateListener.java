package com.liquidforte.oldsong.gridevent.twod;

import com.liquidforte.oldsong.geometry.twod.Grid2D;

public interface Grid2DUpdateListener<G extends Grid2D<G, V>, V> extends Grid2DPointListener<G, V> {
    void handleUpdateEvent(Grid2DUpdateEvent<G, V> event);

    default boolean filterUpdateEvent(Grid2DUpdateEvent<G, V> event) {
        return true;
    }

    @Override
    default void handlePointEvent(Grid2DPointEvent<G, V> event) {
        if (event instanceof Grid2DUpdateEvent<G, V> e) {
            handleUpdateEvent(e);
        }
    }

    @Override
    default boolean filterPointEvent(Grid2DPointEvent<G, V> event) {
        if (event instanceof Grid2DUpdateEvent<G, V> e) {
            return filterUpdateEvent(e);
        }
        return false;
    }
}
