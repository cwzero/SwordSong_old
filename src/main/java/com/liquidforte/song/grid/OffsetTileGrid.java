package com.liquidforte.song.grid;

import com.liquidforte.song.event.GridUpdateEvent;
import com.liquidforte.song.tile.Tile;

public class OffsetTileGrid extends DelegatingTileGrid {
    private int offsetX, offsetY;

    public OffsetTileGrid(TileGridView delegate, int offsetX, int offsetY) {
        super(delegate);
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    @Override
    public boolean filter(GridUpdateEvent event) {
        return contains(event.x - offsetX, event.y - offsetY);
    }

    protected void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    protected void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    protected int getOffsetX() {
        return offsetX;
    }

    protected int getOffsetY() {
        return offsetY;
    }

    @Override
    public boolean contains(int x, int y) {
        return super.contains(x + offsetX, y + offsetY);
    }

    @Override
    protected Tile doGetTile(int x, int y) {
        return super.doGetTile(x + offsetX, y + offsetY);
    }

    @Override
    protected Tile doSetTile(Tile tile, int x, int y) {
        return super.doSetTile(tile, x + offsetX, y + offsetY);
    }
}
