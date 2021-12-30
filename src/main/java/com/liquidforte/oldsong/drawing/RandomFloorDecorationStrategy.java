package com.liquidforte.oldsong.drawing;

import com.liquidforte.oldsong.tile.Direction;
import com.liquidforte.oldsong.tile.FloorDecoration;

import java.util.Random;

public class RandomFloorDecorationStrategy implements FloorDecorationStrategy {
    private final Random random = new Random();

    @Override
    public FloorDecoration getDecoration(int w, int h, int tx, int ty, Direction direction) {
        int i = random.nextInt(2, FloorDecoration.values().length);
        return FloorDecoration.values()[i];
    }
}
