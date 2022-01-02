package com.liquidforte.song.generator.digger;

import com.liquidforte.song.generator.GeneratorConfig;
import com.liquidforte.song.tile.*;
import com.liquidforte.song.world.GameWorld;

import java.awt.*;

public abstract class AbstractDigger extends AbstractSingleton implements Runnable {
    private static final CharTile DIGGER_TILE = new BasicCharTile(Tileset.RIGHT_TRIANGLE);

    protected final GeneratorConfig config;
    protected final GameWorld world;

    public AbstractDigger(GeneratorConfig config, GameWorld world, Color color) {
        super(new BasicColoredTile(DIGGER_TILE, color), false);
        this.config = config;
        this.world = world;
    }

    @Override
    public void run() {
        if (!isPlaced(world)) {
            throw new RuntimeException();
        }
    }

    protected GeneratorConfig getConfig() {
        return config;
    }

    protected GameWorld getWorld() {
        return world;
    }

    protected StackTile getTile() {
        return (StackTile) world.getValue(getPos());
    }

    protected void dig(Tile tile) {
        getTile().setForeground(tile);
    }
}
