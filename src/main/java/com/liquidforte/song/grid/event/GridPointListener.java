package com.liquidforte.song.grid.event;

import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public interface GridPointListener<P extends Point, S extends Size<P>, V> extends GridListener<P, S, V> {
    void handlePointEvent(GridPointEvent<P, S, V> event);

    default boolean filterPointEvent(GridPointEvent<P, S, V> event) {
        return true;
    }

    @Override
    default void handleGridEvent(GridEvent<P, S, V> event) {
        if (event instanceof GridPointEvent<P, S, V> e) {
            handlePointEvent(e);
        }
    }

    @Override
    default boolean filterGridEvent(GridEvent<P, S, V> event) {
        if (event instanceof GridPointEvent<P, S, V> e) {
            return filterPointEvent(e);
        }
        return false;
    }
}
