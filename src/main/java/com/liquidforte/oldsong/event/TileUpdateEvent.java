package com.liquidforte.oldsong.event;

import com.liquidforte.oldsong.tile.Tile;

public class TileUpdateEvent {
    public final Tile oldTile;
    public final Tile newTile;

    public TileUpdateEvent(Tile tile) {
        this(tile, tile);
    }

    public TileUpdateEvent(Tile oldTile, Tile newTile) {
        this.oldTile = oldTile;
        this.newTile = newTile;
    }

    public boolean isReplace() {
        return (oldTile == null && newTile != null) || (oldTile != null && !oldTile.equals(newTile));
    }
}