package com.liquidforte.song.drawing;

import com.liquidforte.song.tile.Direction;
import com.liquidforte.song.tile.FloorDecoration;

public class UniformFloorDecorationStrategy implements FloorDecorationStrategy {
    private final FloorDecoration decoration;

    public UniformFloorDecorationStrategy(FloorDecoration decoration) {
        this.decoration = decoration;
    }

    @Override
    public FloorDecoration getDecoration(int w, int h, int tx, int ty, Direction direction) {
        return decoration;
    }
}
