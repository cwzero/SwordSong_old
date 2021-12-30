package com.liquidforte.oldsong.event;

import java.util.EventListener;

@FunctionalInterface
public interface TileUpdateListener extends EventListener {
    void updateTile(TileUpdateEvent event);

    default boolean filterEvent(TileUpdateEvent event) {
        return true;
    }
}