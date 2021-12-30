package com.liquidforte.song.gridevent.twod;

import com.liquidforte.song.geometry.Grid2D;

import java.util.EventListener;

public interface Grid2DListener<G extends Grid2D<G, V>, V> extends EventListener {
    void handleEvent(Grid2DEvent<G, V> event);

    default boolean filterEvent(Grid2DEvent<G, V> event) {
        return true;
    }
}
