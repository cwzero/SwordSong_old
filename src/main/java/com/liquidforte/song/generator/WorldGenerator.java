package com.liquidforte.song.generator;

import com.liquidforte.song.space.LayeredSpaceGrid;

public interface WorldGenerator {
    GeneratorSpaceGrid generateGrid(int width, int height, int depth);

    LayeredSpaceGrid generateWorld(int width, int height, int depth);
}
