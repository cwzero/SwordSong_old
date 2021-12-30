package com.liquidforte.oldsong.grid.lazy;

import com.liquidforte.oldsong.grid.Drawable;
import com.liquidforte.oldsong.grid.TileGridAccess;

import java.awt.*;
import java.util.function.Consumer;

public interface LazyDrawing extends TileGridAccess {
    default Consumer<Drawable> drawAt(int x, int y) {
        return d -> d.draw(this, x, y);
    }

    default Consumer<Drawable> drawAt(Point pos) {
        return drawAt(pos.x, pos.y);
    }
}
