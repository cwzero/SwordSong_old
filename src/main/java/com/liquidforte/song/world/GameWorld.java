package com.liquidforte.song.world;

import com.liquidforte.song.tile.StackTile;

public class GameWorld {
    private final int width, height, depth;
    private final StackTile[][][] grid;
    private final GameWorldLayer[] layers;

    public GameWorld(int width, int height, int depth) {
        this.layers = new GameWorldLayer[depth];
        this.grid = new StackTile[depth][height][width];
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public StackTile create(int x, int y, int z) {
        if (x < 0 || x > width - 1 || y < 0 || y > height - 1 || z < 0 || z > depth - 1) {
            return null;
        }
        if (grid[z][y][x] == null) {
            grid[z][y][x] = new StackTile();
        }
        return grid[z][y][x];
    }

    public StackTile get(int x, int y, int z) {
        return grid[z][y][x];
    }

    public GameWorldLayer getLayer(int z) {
        if (layers[z] == null) {
            layers[z] = new GameWorldLayer(grid[z], width, height);
        }
        return layers[z];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }
}
