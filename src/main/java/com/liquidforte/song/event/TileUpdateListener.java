package com.liquidforte.song.event;

import java.util.EventListener;

@FunctionalInterface
public interface TileUpdateListener extends EventListener {
    void updateTile(TileUpdateEvent event);
}