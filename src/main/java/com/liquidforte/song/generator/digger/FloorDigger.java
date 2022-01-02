package com.liquidforte.song.generator.digger;

import com.liquidforte.song.generator.GeneratorConfig;
import com.liquidforte.song.world.GameWorld;

import java.awt.*;

public class FloorDigger extends AbstractDigger {
    public FloorDigger(GeneratorConfig config, GameWorld world, Color color) {
        super(config, world, color);
    }
}
