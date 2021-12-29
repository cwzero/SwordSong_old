package com.liquidforte.song.grid.lazy;

import com.liquidforte.song.grid.TileGridAccess;
import com.liquidforte.song.tile.Tile;

import java.awt.*;
import java.util.function.Function;
import java.util.function.Supplier;

public interface LazyTileGridAccess extends TileGridAccess {
    default Supplier<Tile> lazyGetTile(int x, int y) {
        return () -> getTile(x, y);
    }

    default Supplier<Tile> lazyGetTile(Point pos) {
        return () -> getTile(pos);
    }

    default Function<Tile, Tile> lazySetTile(int x, int y) {
        return tile -> setTile(tile, x, y);
    }

    default Function<Tile, Tile> lazySetTile(Point pos) {
        return tile -> setTile(tile, pos);
    }

    default Supplier<Tile> lazyClearTile(int x, int y) {
        return () -> clearTile(x, y);
    }

    default Supplier<Tile> lazyClearTile(Point pos) {
        return () -> clearTile(pos);
    }
}
