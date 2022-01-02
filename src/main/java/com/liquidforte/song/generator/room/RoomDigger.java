package com.liquidforte.song.generator.room;

import com.liquidforte.song.block.Blocks;
import com.liquidforte.song.world.GameWorld;

public class RoomDigger {
    public static void digRoom(GameWorld world, int x, int y, int z, int width, int height) {
        for (int dx = 0; dx < width; dx++) {
            for (int dy = 0; dy < height; dy++) {
                world.create(x + dx, y + dy, z).setBackground(Blocks.SMOOTH_FLOOR);
            }
        }
    }
}
