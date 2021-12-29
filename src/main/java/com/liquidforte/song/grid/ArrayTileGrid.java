package com.liquidforte.song.grid;

import com.liquidforte.song.tile.Tile;

public class ArrayTileGrid extends AbstractTileGrid {
    private final Tile[][] grid;

    public ArrayTileGrid(int width, int height) {
        this.grid = new Tile[width][height];
    }

    @Override
    public int getWidth() {
        return grid.length;
    }

    @Override
    public int getHeight() {
        return grid[0].length;
    }

    @Override
    protected Tile doGetTile(int x, int y) {
        return grid[x][y];
    }

    @Override
    protected Tile doSetTile(Tile tile, int x, int y) {
        Tile result = grid[x][y];
        grid[x][y] = tile;
        return result;
    }
}
