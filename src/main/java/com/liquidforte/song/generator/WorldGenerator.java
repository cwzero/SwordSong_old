package com.liquidforte.song.generator;

import com.liquidforte.song.block.Blocks;
import com.liquidforte.song.generator.room.RoomDigger;
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

        /*world.create(0, 0, 0).setTile(Blocks.NORTH_WEST_CORNER);
        world.create(width - 1, 0, 0).setTile(Blocks.NORTH_EAST_CORNER);
        world.create(0, height - 1, 0).setTile(Blocks.SOUTH_WEST_CORNER);
        world.create(width - 1, height - 1, 0).setTile(Blocks.SOUTH_EAST_CORNER);*/

        RoomDigger.digRoom(world, 30, 20, 0, 10, 10);

        // TODO: generate world
        // TODO: place player

        player.place(width / 2, height / 2, 0);
        return world;
    }
}
