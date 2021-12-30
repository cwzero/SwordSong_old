package com.liquidforte.oldsong.drawing;

import com.liquidforte.oldsong.tile.Direction;
import com.liquidforte.oldsong.tile.FloorDecoration;

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
