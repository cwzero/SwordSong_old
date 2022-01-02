package com.liquidforte.song.generator;

import com.liquidforte.song.generator.digger.WorldDigger;
import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.player.Player;
import com.liquidforte.song.world.DefaultGameWorld;
import com.liquidforte.song.world.GameWorld;

import java.awt.*;

public class WorldGeneratorImpl implements WorldGenerator {
    private final GeneratorConfig config;
    private final Player player;

    // TODO: pass in player
    public WorldGeneratorImpl(GeneratorConfig config, Player player) {
        this.config = config;
        this.player = player;
    }

    @Override
    public GameWorld generate() {
        int width = config.getWidth();
        int height = config.getHeight();
        int depth = config.getDepth();

        GameWorld world = new DefaultGameWorld(config.getWidth(), config.getHeight(), config.getDepth());

        Point3D center = new Point3D(config.getWidth() / 2, config.getHeight() / 2, 0);

        WorldDigger digger = new WorldDigger(config, this, world, Color.orange);
        digger.place(world, center);
        digger.run();

        //player.place(world, new Point3D(3, 3, 0));

        return world;
    }
}
