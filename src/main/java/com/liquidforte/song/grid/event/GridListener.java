package com.liquidforte.song.grid.event;

import com.liquidforte.song.event.EventListener;
import com.liquidforte.song.math.geometry.Point;

public interface GridListener<P extends Point, V> extends EventListener {
    void handleGridEvent(GridEvent<P, V> event);

    default boolean filterGridEvent(GridEvent<P, V> event) {
        return true;
    }
}
