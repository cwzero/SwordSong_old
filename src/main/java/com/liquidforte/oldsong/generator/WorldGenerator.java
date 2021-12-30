package com.liquidforte.oldsong.generator;

import com.liquidforte.oldsong.space.LayeredSpaceGrid;

public interface WorldGenerator {
    GeneratorSpaceGrid generateGrid(int width, int height, int depth);

    LayeredSpaceGrid generateWorld(int width, int height, int depth);
}
