package com.liquidforte.song.grid.event;

import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public interface GridUpdateListener<P extends Point, S extends Size<P>, V> extends GridAddListener<P, S, V>, GridRemoveListener<P, S, V> {
    void handleUpdateEvent(GridUpdateEvent<P, S, V> event);

    default boolean filterUpdateEvent(GridUpdateEvent<P, S, V> event) {
        return true;
    }

    @Override
    default void handleAddEvent(GridAddEvent<P, S, V> event) {
        if (event instanceof GridUpdateEvent<P, S, V> e) {
            handleUpdateEvent(e);
        }
    }

    @Override
    default boolean filterAddEvent(GridAddEvent<P, S, V> event) {
        if (event instanceof GridUpdateEvent<P, S, V> e) {
            return filterUpdateEvent(e);
        }
        return false;
    }

    @Override
    default void handleRemoveEvent(GridRemoveEvent<P, S, V> event) {
        if (event instanceof GridUpdateEvent<P, S, V> e) {
            handleUpdateEvent(e);
        }
    }

    @Override
    default boolean filterRemoveEvent(GridRemoveEvent<P, S, V> event) {
        if (event instanceof GridUpdateEvent<P, S, V> e) {
            return filterUpdateEvent(e);
        }
        return false;
    }

    @Override
    default void handlePointEvent(GridPointEvent<P, S, V> event) {
        if (event instanceof GridUpdateEvent<P, S, V> e) {
            handleUpdateEvent(e);
        } else if (event instanceof GridAddEvent<P, S, V> e) {
            handleAddEvent(e);
        } else if (event instanceof GridRemoveEvent<P, S, V> e) {
            handleRemoveEvent(e);
        }
    }

    @Override
    default boolean filterPointEvent(GridPointEvent<P, S, V> event) {
        if (event instanceof GridUpdateEvent<P, S, V> e) {
            return filterUpdateEvent(e);
        } else if (event instanceof GridAddEvent<P, S, V> e) {
            return filterAddEvent(e);
        } else if (event instanceof GridRemoveEvent<P, S, V> e) {
            return filterRemoveEvent(e);
        }
        return false;
    }
}
