package com.liquidforte.song.main;

import com.liquidforte.song.generator.WorldGenerator;
import com.liquidforte.song.player.Player;
import com.liquidforte.song.player.PlayerController;
import com.liquidforte.song.ui.GameWindow;
import com.liquidforte.song.ui.UIContainer;
import com.liquidforte.song.world.GameWorld;

public class Main {
    public static void main(String[] args) {
        UIContainer container = new UIContainer(101, 57);
        GameWindow window = new GameWindow(container);
        window.start();

        Player player = new Player();
        WorldGenerator generator = new WorldGenerator(player);
        GameWorld world = generator.generate(101, 57, 5);
        Runnable updateFn = () -> {
            player.getLayer().draw(container.getGraphics());
            window.repaint();
        };
        PlayerController controller = new PlayerController(player, updateFn);
        window.addKeyListener(controller);

        updateFn.run();
    }
}
