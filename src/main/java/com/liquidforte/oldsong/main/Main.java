package com.liquidforte.oldsong.main;

import com.liquidforte.oldsong.generator.WorldGeneratorImpl;
import com.liquidforte.oldsong.ui.GameWindow;
import com.liquidforte.oldsong.generator.WorldGenerator;
import com.liquidforte.oldsong.grid.TileGridView;
import com.liquidforte.oldsong.space.LayeredSpaceGrid;
import com.liquidforte.oldsong.space.SpaceGrid;
import com.liquidforte.oldsong.ui.GamePanel;

public class Main {
    public static void main(String[] args) {
        testWindow();
    }

    public static void testWindow() {
        GamePanel gamePanel = new GamePanel(103, 59);
        GameWindow gameWindow = new GameWindow(gamePanel);
        gameWindow.start();

        TileGridView grid = gamePanel.getGrid();
        WorldGenerator generator = new WorldGeneratorImpl();
        LayeredSpaceGrid world = generator.generateWorld(256, 256, 5);

        // TODO: composite game view, entity view -> player view
        SpaceGrid view = world.getSpaceLayer(0);
        // TODO: set view coordinates based on player
        int offsetX = 100, offsetY = 100;
        grid.addOverlay(view, offsetX, offsetY, 0, 0, 103, 59);

        // TODO: place player into world in WorldGenerator
        /*Player player = new Player(world, new ColoredTile(Tileset.AT, Color.blue));
        player.moveTo(101, 101, 0);

        // TODO: Do this elsewhere?
        PlayerController playerController = new PlayerController(player);
        gameWindow.addKeyListener(playerController);*/
    }
}
