package com.liquidforte.song.generator.room;

import com.liquidforte.song.block.Blocks;
import com.liquidforte.song.world.GameWorldLayer;

public class RoomDigger {
    public static void digRoom(GameWorldLayer layer, int x, int y, int width, int height) {
        for (int dx = 0; dx < width; dx++) {
            for (int dy = 0; dy < height; dy++) {
                layer.create(x + dx, y + dy).setBackground(Blocks.SMOOTH_FLOOR);
            }
        }
    }
}
