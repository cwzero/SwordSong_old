package com.liquidforte.oldsong.event;

import com.liquidforte.oldsong.grid.TileGrid;
import com.liquidforte.oldsong.tile.Tile;

import java.awt.*;

public class GridTileUpdateEvent extends GridUpdateEvent {
    public final Tile oldTile;
    public final Tile newTile;
    public final int x, y;

    public GridTileUpdateEvent(TileGrid grid, Tile oldTile, Tile newTile, Point pos) {
        this(grid, oldTile, newTile, pos.x, pos.y);
    }

    public GridTileUpdateEvent(TileGrid grid, Tile oldTile, Tile newTile, int x, int y) {
        super(grid);
        this.oldTile = oldTile;
        this.newTile = newTile;
        this.x = x;
        this.y = y;
    }

    public Tile getOldTile() {
        return oldTile;
    }

    public Tile getNewTile() {
        return newTile;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
