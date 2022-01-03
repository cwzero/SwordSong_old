package com.liquidforte.song.world;

import com.liquidforte.song.tile.StackTile;

import java.awt.*;

public class GameWorldLayer {
    private final int width, height;
    private final StackTile[][] grid;

    public GameWorldLayer(StackTile[][] grid, int width, int height) {
        this.grid = grid;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public StackTile get(int x, int y) {
        return grid[y][x];
    }

    public StackTile create(int x, int y) {
        if (grid[y][x] == null) {
            grid[y][x] = new StackTile();
        }
        return grid[y][x];
    }

    public void draw(Graphics2D graphics) {
        graphics.setBackground(Color.black);
        graphics.clearRect(0, 0, width * 16, height * 16);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                StackTile tile = grid[y][x];
                if (tile != null) {
                    tile.draw(graphics, x, y);
                }
            }
        }
    }
}
