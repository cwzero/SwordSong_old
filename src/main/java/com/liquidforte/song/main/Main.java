package com.liquidforte.song.main;

import com.liquidforte.song.generator.WorldGenerator;
import com.liquidforte.song.player.Player;
import com.liquidforte.song.player.PlayerController;
import com.liquidforte.song.ui.GameWindow;
import com.liquidforte.song.ui.UIContainer;
import com.liquidforte.song.world.GameWorld;

public class Main {
    public static void main(String[] args) {
        int width = 101;
        int height = 57;
        int depth = 5;

        UIContainer container = new UIContainer(width, height);
        GameWindow window = new GameWindow(container);
        window.start();

        Player player = new Player();
        WorldGenerator generator = new WorldGenerator(player);
        GameWorld world = generator.generate(width, height, depth);

        Runnable updateFn = () -> {
            player.getLayer().draw(container.getGraphics());
            window.repaint();
        };

        PlayerController controller = new PlayerController(player, updateFn);
        window.addKeyListener(controller);

        updateFn.run();
    }
}
