package com.liquidforte.song.event;

import com.liquidforte.song.tile.Tile;

public interface MovementEvent {
    Tile getTile();

    int getSourceX();
    int getSourceY();
    int getSourceZ();

    int getDestX();
    int getDestY();
    int getDestZ();

    void cancel();
    boolean isCancelled();
}
