package com.liquidforte.song.main;

import com.liquidforte.song.grid.ArrayTileGrid;
import com.liquidforte.song.grid.TileGridView;
import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.ui.GameWindow;
import com.liquidforte.song.ui.GridPanel;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        testWindow();
    }

    public static void testGrid() {
        /*Tile tile = Tile.create(0, 4);
        ArrayTileGrid grid = new ArrayTileGrid(1, 1);
        ArrayTileGrid grid2 = grid.createSection(0, 0, 1, 1);
        grid.addGridUpdateListener(System.out::println);
        grid2.setTile(tile, 0, 0);*/
    }

    public static void testWindow() {
        GridPanel gridPanel = new GridPanel(103, 59);
        GameWindow gameWindow = new GameWindow(gridPanel);
        gameWindow.start();

        Tile tile = Tile.create(0, 4, Color.blue);
        TileGridView grid = gridPanel.getGrid();
        TileGridView view = new ArrayTileGrid(256, 256);
        int offsetX = 100, offsetY = 100;
        grid.addOverlay(view, offsetX, offsetY, 0, 0, 80, 30);

        view.setTile(tile, 0, 0);
        view.setTile(tile, 100, 100);
        view.setTile(tile, 179, 129);
    }
}
