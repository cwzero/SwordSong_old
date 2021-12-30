package com.liquidforte.oldsong.grid;

import java.awt.*;

@FunctionalInterface
public interface Drawable {
    void draw(TileGridAccess grid, int x, int y);

    default void draw(TileGridAccess grid, Point pos) {
        draw(grid, pos.x, pos.y);
    }
}
