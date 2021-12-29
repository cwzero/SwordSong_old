package com.liquidforte.song.event;

import com.liquidforte.song.grid.TileGrid;
import com.liquidforte.song.tile.Tile;

import java.awt.*;

public class GridUpdateEvent {
    public final TileGrid grid;
    public final Tile oldTile;
    public final Tile newTile;
    public final int x, y;

    public GridUpdateEvent(TileGrid grid, Tile oldTile, Tile newTile, Point pos) {
        this(grid, oldTile, newTile, pos.x, pos.y);
    }

    public GridUpdateEvent(TileGrid grid, Tile oldTile, Tile newTile, int x, int y) {
        this.grid = grid;
        this.oldTile = oldTile;
        this.newTile = newTile;
        this.x = x;
        this.y = y;
    }

    public TileGrid getGrid() {
        return grid;
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
