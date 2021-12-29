package com.liquidforte.song.drawing;

import com.liquidforte.song.tile.Direction;
import com.liquidforte.song.tile.FloorDecoration;

public interface FloorDecorationStrategy {
    FloorDecoration getDecoration(int w, int h, int tx, int ty, Direction direction);
}
