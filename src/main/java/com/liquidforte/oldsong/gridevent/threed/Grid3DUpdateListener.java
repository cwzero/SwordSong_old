package com.liquidforte.oldsong.gridevent.threed;

import com.liquidforte.oldsong.geometry.threed.Grid3D;

public interface Grid3DUpdateListener<G extends Grid3D<G, V>, V> extends Grid3DPointListener<G, V> {
    void handleUpdateEvent(Grid3DUpdateEvent<G, V> event);

    default boolean filterUpdateEvent(Grid3DUpdateEvent<G, V> event) {
        return true;
    }

    @Override
    default void handlePointEvent(Grid3DPointEvent<G, V> event) {
        if (event instanceof Grid3DUpdateEvent<G, V> e) {
            handleUpdateEvent(e);
        }
    }

    @Override
    default boolean filterPointEvent(Grid3DPointEvent<G, V> event) {
        if (event instanceof Grid3DUpdateEvent<G, V> e) {
            return filterUpdateEvent(e);
        }
        return false;
    }
}
