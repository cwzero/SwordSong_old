package com.liquidforte.oldsong.drawing;

import com.liquidforte.oldsong.tile.Direction;
import com.liquidforte.oldsong.tile.FloorDecoration;

public interface FloorDecorationStrategy {
    FloorDecoration getDecoration(int w, int h, int tx, int ty, Direction direction);
}
