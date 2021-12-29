package com.liquidforte.song.space;

import com.liquidforte.song.grid.ArrayTileGrid;
import com.liquidforte.song.grid.TileGridAccess;
import com.liquidforte.song.tile.Tile;

import java.awt.*;

public class SpaceGrid extends ArrayTileGrid {
    public SpaceGrid(int width, int height) {
        super(width, height);
    }

    public SpaceGrid(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public synchronized Space createSpace(int x, int y) {
        if (getTile(x, y) == null) {
            setTile(new Space(), x, y);
        }
        return (Space) getTile(x, y);
    }

    public Space getSpace(int x, int y) {
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

    @Override
    public void drawArea(TileGridAccess grid, int yourOffsetX, int yourOffsetY, int myOffsetX, int myOffsetY, int width, int height) {
        int myWidth = getWidth() - myOffsetX;
        int myHeight = getHeight() - myOffsetY;

        int yourWidth = grid.getWidth() - yourOffsetX;
        int yourHeight = grid.getHeight() - yourOffsetY;

        int runWidth = Math.min(myWidth, yourWidth);
        int runHeight = Math.min(myHeight, yourHeight);

        for (int x = 0; x < runWidth; x++) {
            for (int y = 0; y < runHeight; y++) {
                Space space = getSpace(x + myOffsetX, y + myOffsetY);
                if (space != null && space.getTile() != null) {
                    grid.setTile(space.getTile(), x + yourOffsetX, y + yourOffsetY);
                }
            }
        }
    }
}
