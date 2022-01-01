package com.liquidforte.song.main;

import com.liquidforte.song.math.geometry.two.Size2D;
import com.liquidforte.song.tilegrid.two.DefaultTileGrid2D;
import com.liquidforte.song.ui.GridWindow;

public class Main {
    public static void main(String[] args) {
        var size = new Size2D(101, 57);
        var grid = new DefaultTileGrid2D(size);
        var window = new GridWindow(grid, size);
        window.start();
    }
}
