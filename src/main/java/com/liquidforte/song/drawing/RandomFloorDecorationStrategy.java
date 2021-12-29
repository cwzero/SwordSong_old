package com.liquidforte.song.drawing;

import com.liquidforte.song.tile.Direction;
import com.liquidforte.song.tile.FloorDecoration;

import java.util.Random;

public class RandomFloorDecorationStrategy implements FloorDecorationStrategy {
    private final Random random = new Random();

    @Override
    public FloorDecoration getDecoration(int w, int h, int tx, int ty, Direction direction) {
        int i = random.nextInt(2, FloorDecoration.values().length);
        return FloorDecoration.values()[i];
    }
}
