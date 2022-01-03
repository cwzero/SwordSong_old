package com.liquidforte.song.generator;

import com.liquidforte.song.generator.room.BSPTree;
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

        BSPTree tree = new BSPTree(world.getLayer(0));
        tree.split();
        tree.draw(world.getLayer(0));

        // TODO: generate world
        // TODO: place player

        player.place(width / 2, height / 2, 0);
        return world;
    }
}
