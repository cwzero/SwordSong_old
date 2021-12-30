package com.liquidforte.song.grid.event;

import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public interface GridRemoveListener<P extends Point<P>, S extends Size<P, S>, V> extends GridPointListener<P, S, V> {
    void handleRemoveEvent(GridRemoveEvent<P, S, V> event);

    default boolean filterRemoveEvent(GridRemoveEvent<P, S, V> event) {
        return true;
    }

    @Override
    default void handlePointEvent(GridPointEvent<P, S, V> event) {
        if (event instanceof GridRemoveEvent<P, S, V> e) {
            handleRemoveEvent(e);
        }
    }

    @Override
    default boolean filterPointEvent(GridPointEvent<P, S, V> event) {
        if (event instanceof GridRemoveEvent<P, S, V> e) {
            return filterRemoveEvent(e);
        }
        return false;
    }
}
