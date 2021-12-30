package com.liquidforte.song.grid.event;

import com.liquidforte.song.event.EventSource;
import com.liquidforte.song.math.geometry.Point;

public interface GridEventSource<P extends Point, V> extends EventSource {
    default <T extends GridListener<P, V>, L extends T> void addGridListener(Class<T> listenerClass, L listener) {
        addListener(listenerClass, listener);
    }

    default <T extends GridListener<P, V>, L extends T> void removeGridListener(Class<T> listenerClass, L listener) {
        removeListener(listenerClass, listener);
    }
}
