package com.liquidforte.song.grid.event;

import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public interface GridAddListener<P extends Point<P>, S extends Size<P, S>, V> extends GridPointListener<P, S, V> {
    void handleAddEvent(GridAddEvent<P, S, V> event);

    default boolean filterAddEvent(GridAddEvent<P, S, V> event) {
        return true;
    }

    @Override
    default void handlePointEvent(GridPointEvent<P, S, V> event) {
        if (event instanceof GridAddEvent<P, S, V> e) {
            handleAddEvent(e);
        }
    }

    @Override
    default boolean filterPointEvent(GridPointEvent<P, S, V> event) {
        if (event instanceof GridAddEvent<P, S, V> e) {
            return filterAddEvent(e);
        }
        return false;
    }
}
