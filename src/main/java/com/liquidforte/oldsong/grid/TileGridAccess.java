package com.liquidforte.oldsong.grid;

import com.liquidforte.oldsong.event.GridUpdateListener;
import com.liquidforte.oldsong.tile.Tile;

import java.awt.*;
import java.awt.event.KeyListener;

public interface TileGridAccess {
    int getWidth();

    int getHeight();

    default Dimension getSize() {
        return new Dimension(getWidth(), getHeight());
    }

    boolean contains(int x, int y);

    default boolean contains(Point pos) {
        return contains(pos.x, pos.y);
    }

    Tile getTile(int x, int y);

    default Tile getTile(Point pos) {
        return getTile(pos.x, pos.y);
    }

    Tile setTile(Tile tile, int x, int y);

    default Tile setTile(Tile tile, Point pos) {
        return setTile(tile, pos.x, pos.y);
    }

    default Tile clearTile(int x, int y) {
        return setTile(null, x, y);
    }

    default Tile clearTile(Point pos) {
        return clearTile(pos.x, pos.y);
    }

    void addListener(GridUpdateListener listener);

    void addKeyListener(KeyListener keyListener);
}
