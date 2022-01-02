package com.liquidforte.song.generator;

import com.liquidforte.song.block.Blocks;
import com.liquidforte.song.player.Player;
import com.liquidforte.song.world.GameWorld;

public class WorldGenerator {
    private final Player player;

    public WorldGenerator() {
        this(new Player());
    }

    public WorldGenerator(Player player) {
        this.player = player;
    }

    public GameWorld generate(int width, int height, int depth) {
        GameWorld world = new GameWorld(width, height, depth);
        player.setWorld(world);

        world.create(0, 0, 0).setTile(Blocks.NORTH_WEST_CORNER);

        // TODO: generate world
        // TODO: place player

        player.place(width / 2, height / 2, 0);
        return world;
    }
}
