package com.liquidforte.song.grid;

public class SubGrid extends OffsetTileGrid {
    private final int width, height;

    public SubGrid(TileGridView delegate, int x, int y, int width, int height) {
        super(delegate, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return Math.min(width, super.getWidth() - getOffsetX());
    }

    @Override
    public int getHeight() {
        return Math.min(height, super.getHeight() - getOffsetY());
    }

    @Override
    public boolean contains(int x, int y) {
        return super.contains(x, y) && x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
    }
}
