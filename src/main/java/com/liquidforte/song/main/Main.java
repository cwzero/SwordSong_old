package com.liquidforte.song.main;

import com.liquidforte.song.drawing.RandomFloorDecorationStrategy;
import com.liquidforte.song.drawing.RoomDrawing;
import com.liquidforte.song.grid.TileGridView;
import com.liquidforte.song.space.LayeredSpaceGrid;
import com.liquidforte.song.space.SpaceGrid;
import com.liquidforte.song.tile.ColoredTile;
import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.tile.WallTiles;
import com.liquidforte.song.ui.GamePanel;
import com.liquidforte.song.ui.GameWindow;
import com.liquidforte.song.util.Tileset;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        testWindow();
    }

    public static void testWindow() {
        GamePanel gamePanel = new GamePanel(103, 59);
        GameWindow gameWindow = new GameWindow(gamePanel);
        gameWindow.start();

        TileGridView grid = gamePanel.getGrid();
        LayeredSpaceGrid world = new LayeredSpaceGrid(256, 256, 5);
        SpaceGrid view = world.getSpaceLayer(0);
        int offsetX = 100, offsetY = 100;
        grid.addOverlay(view, offsetX, offsetY, 0, 0, 103, 59);

        WallTiles wallTiles = new WallTiles(Color.darkGray, Color.lightGray, Color.white);
        RoomDrawing roomDrawing = new RoomDrawing(wallTiles);
        roomDrawing.drawRoom(view, new RandomFloorDecorationStrategy(), 100, 100, 10, 10);

        Tile player = new ColoredTile(Tileset.AT, Color.blue);
        view.getSpace(101, 101).setForeground(player);
    }
}
