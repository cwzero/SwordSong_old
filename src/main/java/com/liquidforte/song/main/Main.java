package com.liquidforte.song.main;

import com.liquidforte.song.math.geometry.three.Size3D;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.Size2D;
import com.liquidforte.song.tile.BasicColoredTile;
import com.liquidforte.song.tile.Tileset;
import com.liquidforte.song.tilegrid.three.DefaultTileGrid3D;
import com.liquidforte.song.ui.GridWindow;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        var worldSize = new Size3D(256, 256, 5);
        var world = new DefaultTileGrid3D(worldSize);

        var offset = new Point2D(100, 100);
        var size = new Size2D(101, 57);
        var grid = world.getLayer(0)
                .map(offset)
                .filter(size);
        var window = new GridWindow(grid, size);
        window.start();

        var offset2 = new Point2D(50, 26);
        var g2 = grid.map(offset2);

        g2.setValue(-10, -10, new BasicColoredTile(Tileset.AT, Color.blue));
        System.out.println(world.getValue(140, 116, 0));
    }
}
