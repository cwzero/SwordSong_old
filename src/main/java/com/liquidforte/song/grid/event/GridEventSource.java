package com.liquidforte.song.grid.event;

import com.liquidforte.song.event.EventSource;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

@SuppressWarnings("unchecked")
public interface GridEventSource<P extends Point, S extends Size<P>, V> extends EventSource {
    default void addGridListener(GridListener<P, S, V> listener) {
        addGridListener(GridListener.class, listener);
    }

    default <T extends GridListener<P, S, V>, L extends T> void addGridListener(Class<T> listenerClass, L listener) {
        addListener(listenerClass, listener);
    }

    default <L extends GridAddListener<P, S, V>> void addGridAddListener(L listener) {
        addGridListener(GridAddListener.class, listener);
    }

    default <L extends GridPointListener<P, S, V>> void addGridPointListener(L listener) {
        addGridListener(GridPointListener.class, listener);
    }

    default <L extends GridRemoveListener<P, S, V>> void addGridRemoveListener(L listener) {
        addGridListener(GridRemoveListener.class, listener);
    }

    default <L extends GridUpdateListener<P, S, V>> void addGridUpdateListener(L listener) {
        addGridListener(GridUpdateListener.class, listener);
    }

    default <T extends GridListener<P, S, V>, L extends T> void removeGridListener(Class<T> listenerClass, L listener) {
        removeListener(listenerClass, listener);
    }

    default <L extends GridAddListener<P, S, V>> void removeGridAddListener(L listener) {
        removeGridListener(GridAddListener.class, listener);
    }

    default <L extends GridPointListener<P, S, V>> void removeGridPointListener(L listener) {
        removeGridListener(GridPointListener.class, listener);
    }

    default <L extends GridRemoveListener<P, S, V>> void removeGridRemoveListener(L listener) {
        removeGridListener(GridRemoveListener.class, listener);
    }

    default <L extends GridUpdateListener<P, S, V>> void removeGridUpdateListener(L listener) {
        removeGridListener(GridUpdateListener.class, listener);
    }
}
