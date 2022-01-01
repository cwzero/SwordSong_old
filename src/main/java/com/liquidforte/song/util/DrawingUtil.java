package com.liquidforte.song.util;

import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.tilegrid.two.TileGrid2D;

import java.awt.*;

public class DrawingUtil {
    public static void drawGrid(TileGrid2D grid, Graphics2D graphics, int x, int y, int width, int height) {
        for (int tx = 0; tx < width; tx++) {
            for (int ty = 0; ty < width; ty++) {
                Tile tile = grid.getValue(x + tx, y + ty);
                if (tile != null) {
                    graphics.drawImage(tile.getTexture(), (x + tx) * 16, (y + ty) * 16, null);
                }
            }
        }
    }
}
