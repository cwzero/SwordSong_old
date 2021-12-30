package com.liquidforte.song.gridevent;

import com.liquidforte.song.geometry.Point;

import java.util.EventListener;

public interface GridListener<P extends Point, V> extends EventListener {
    void handleGridEvent(GridEvent<P, V> event);

    default boolean filterGridEvent(GridEvent<P, V> event) {
        return true;
    }
}
