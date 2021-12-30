package com.liquidforte.song.grid.event;

import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

@SuppressWarnings("unchecked")
public interface FireGridEvent<P extends Point, S extends Size<P>, V> {
    <T extends GridListener<P, S, V>, E extends GridEvent<P, S, V>> E fireGridEvent(Class<T> listenerClass, BiPredicate<T, E> filter, BiConsumer<T, E> handler, E event);

    default GridEvent<P, S, V> fireGridEvent(GridEvent<P, S, V> event) {
        return fireGridEvent(GridListener.class, GridListener::filterEvent, GridListener::handleEvent, event);
    }

    default GridAddEvent<P, S, V> fireGridAddEvent(GridAddEvent<P, S, V> event) {
        fireGridPointEvent(event);
        return fireGridEvent(GridAddListener.class, GridAddListener::filterAddEvent, GridAddListener::handleAddEvent, event);
    }

    default GridPointEvent<P, S, V> fireGridPointEvent(GridPointEvent<P, S, V> event) {
        fireGridEvent(event);
        return fireGridEvent(GridPointListener.class, GridPointListener::filterPointEvent, GridPointListener::handlePointEvent, event);
    }

    default GridRemoveEvent<P, S, V> fireGridRemoveEvent(GridRemoveEvent<P, S, V> event) {
        fireGridPointEvent(event);
        return fireGridEvent(GridRemoveListener.class, GridRemoveListener::filterRemoveEvent, GridRemoveListener::handleRemoveEvent, event);
    }

    default GridUpdateEvent<P, S, V> fireGridUpdateEvent(GridUpdateEvent<P, S, V> event) {
        fireGridRemoveEvent(event);
        fireGridAddEvent(event);
        return fireGridEvent(GridUpdateListener.class, GridUpdateListener::filterUpdateEvent, GridUpdateListener::handleUpdateEvent, event);
    }
}
