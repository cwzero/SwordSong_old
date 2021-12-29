package com.liquidforte.song.grid;

public interface TileGridView extends TileGridAccess, GridDrawing {
    TileGridView createSubGrid(int x, int y, int width, int height);

    TileGridView createOffsetGrid(int x, int y);

    default TileGridView centered() {
        return createOffsetGrid(getWidth() / 2, getHeight() / 2);
    }

    void addOverlay(GridDrawing source, int yourOffsetX, int yourOffsetY, int myOffsetX, int myOffsetY, int width, int height);
}
