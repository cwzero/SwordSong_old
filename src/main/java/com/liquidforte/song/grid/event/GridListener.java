package com.liquidforte.song.grid.event;

import com.liquidforte.song.event.Event;
import com.liquidforte.song.event.EventListener;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public interface GridListener<P extends Point<P>, S extends Size<P, S>, V> extends EventListener {
    void handleGridEvent(GridEvent<P, S, V> event);

    default boolean filterGridEvent(GridEvent<P, S, V> event) {
        return true;
    }

    @Override
    default void handleEvent(Event event) {

    }

    default boolean filterEvent(Event event) {
        return false;
    }
}
