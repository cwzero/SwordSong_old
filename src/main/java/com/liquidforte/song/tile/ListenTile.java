package com.liquidforte.song.tile;

import com.liquidforte.song.event.TileUpdateListener;

public interface ListenTile extends Tile {
    void addUpdateListener(TileUpdateListener listener);

    void removeUpdateListener(TileUpdateListener listener);
}
