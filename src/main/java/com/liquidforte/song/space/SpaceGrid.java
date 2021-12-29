package com.liquidforte.song.space;

import com.liquidforte.song.grid.ArrayTileGrid;
import com.liquidforte.song.tile.Tile;

import java.awt.*;

public class SpaceGrid extends ArrayTileGrid {
    public SpaceGrid(int width, int height) {
        super(width, height);
    }

    public SpaceGrid(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public synchronized Space getSpace(int x, int y) {
        if (getTile(x, y) == null) {
            setTile(new Space(), x, y);
        }
        return (Space) getTile(x, y);
    }

    @Override
    protected Tile doGetTile(int x, int y) {
        return super.doGetTile(x, y);
    }

    @Override
    protected Tile doSetTile(Tile tile, int x, int y) {
        return super.doSetTile(tile, x, y);
    }
}
