package com.liquidforte.oldsong.tile;

import com.liquidforte.oldsong.event.TileUpdateListener;

public interface ListenTile extends Tile {
    void addUpdateListener(TileUpdateListener listener);

    void removeUpdateListener(TileUpdateListener listener);
}
