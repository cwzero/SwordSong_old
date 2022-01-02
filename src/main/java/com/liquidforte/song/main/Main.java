package com.liquidforte.song.main;

import com.liquidforte.song.generator.GeneratorConfig;
import com.liquidforte.song.generator.WorldGenerator;
import com.liquidforte.song.generator.WorldGeneratorImpl;
import com.liquidforte.song.math.geometry.two.Size2D;
import com.liquidforte.song.player.Player;
import com.liquidforte.song.player.PlayerInput;
import com.liquidforte.song.ui.GridWindow;
import com.liquidforte.song.view.PlayerView;
import com.liquidforte.song.view.PlayerViewImpl;
import com.liquidforte.song.world.GameWorld;

public class Main {
    public static void main(String[] args) {
        GeneratorConfig config = new GeneratorConfig(256, 256, 5);
        Player player = new Player();
        WorldGenerator generator = new WorldGeneratorImpl(config, player);
        GameWorld world = generator.generate();

        Size2D size = new Size2D(81, 43);
        PlayerView view = new PlayerViewImpl(world, player, size);

        GridWindow window = new GridWindow(view, new Size2D(101, 57));
        window.start();

        PlayerInput input = new PlayerInput(world, player);
        window.addKeyListener(input);
    }
}
