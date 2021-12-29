package com.liquidforte.song.main;

import com.liquidforte.song.block.Block;
import com.liquidforte.song.block.RoomBlock;
import com.liquidforte.song.grid.TileGridView;
import com.liquidforte.song.space.LayeredSpaceGrid;
import com.liquidforte.song.space.SpaceGrid;
import com.liquidforte.song.tile.*;
import com.liquidforte.song.ui.GamePanel;
import com.liquidforte.song.ui.GameWindow;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        testWindow();
    }

    public static void testWindow() {
        GamePanel gamePanel = new GamePanel(103, 59);
        GameWindow gameWindow = new GameWindow(gamePanel);
        gameWindow.start();

        WallTiles wallTiles = new WallTiles(Color.green, Color.white, Color.blue);
        Tile tile = new ColoredTile(wallTiles.wallCornerNESparse, new Color(1f, 0.1f, 0f, 0.3f));
        Tile tile2 = new LayeredTile(tile, wallTiles.wallCornerNESparse);
        TileGridView grid = gamePanel.getGrid();
        LayeredSpaceGrid world = new LayeredSpaceGrid(256, 256, 5);
        SpaceGrid view = world.getSpaceLayer(0);
        int offsetX = 100, offsetY = 100;
        grid.addOverlay(view, offsetX, offsetY, 0, 0, 103, 59);

        Block cornerBlock = new RoomBlock(wallTiles, Direction.Northeast, FloorDecoration.Sparse);
        view.getSpace(100, 100).setBackground(cornerBlock);
        view.getSpace(101, 100).setBackground(cornerBlock);
        view.getSpace(100, 101).setBackground(cornerBlock);
    }
}
