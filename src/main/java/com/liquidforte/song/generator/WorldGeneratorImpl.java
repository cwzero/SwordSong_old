package com.liquidforte.song.generator;

import com.liquidforte.song.world.DefaultGameWorld;
import com.liquidforte.song.world.GameWorld;

public class WorldGeneratorImpl implements WorldGenerator {
    private final GeneratorConfig config;

    public WorldGeneratorImpl(GeneratorConfig config) {
        this.config = config;
    }

    @Override
    public GameWorld generate() {
        int width = config.getWidth();
        int height = config.getHeight();
        int depth = config.getDepth();

        GameWorld world = new DefaultGameWorld(config.getWidth(), config.getHeight(), config.getDepth());

        return world;
    }
}
