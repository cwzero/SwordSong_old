package com.liquidforte.song.generator.digger;

import com.liquidforte.song.generator.GeneratorConfig;
import com.liquidforte.song.generator.WorldGenerator;
import com.liquidforte.song.world.GameWorld;

import java.awt.*;

public class WorldDigger extends AbstractDigger {
    private final WorldGenerator generator;

    public WorldDigger(GeneratorConfig config, WorldGenerator generator, GameWorld world, Color color) {
        super(config, world, color);
        this.generator = generator;
    }

    @Override
    public void run() {
        super.run();
    }
}
