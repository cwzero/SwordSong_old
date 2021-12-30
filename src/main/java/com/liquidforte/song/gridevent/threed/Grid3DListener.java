package com.liquidforte.song.gridevent.threed;

import com.liquidforte.song.geometry.threed.Grid3D;

import java.util.EventListener;

public interface Grid3DListener<G extends Grid3D<G, V>, V> extends EventListener {
    void handleEvent(Grid3DEvent<G, V> event);

    default boolean filterEvent(Grid3DEvent<G, V> event) {
        return true;
    }
}
