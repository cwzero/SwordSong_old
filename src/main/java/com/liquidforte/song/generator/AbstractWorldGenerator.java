package com.liquidforte.song.generator;

import com.liquidforte.song.space.LayeredSpaceGrid;

public abstract class AbstractWorldGenerator extends AbstractGenerator implements WorldGenerator {
    @Override
    public GeneratorSpaceGrid generateGrid(int width, int height, int depth) {
        GeneratorSpaceGrid result = new GeneratorSpaceGrid(width, height, depth);
        doGenerateGrid(result);
        return result;
    }

    protected abstract void doGenerateGrid(GeneratorSpaceGrid grid);

    protected abstract void doGenerateWorld(GeneratorSpaceGrid source, LayeredSpaceGrid world);

    @Override
    public LayeredSpaceGrid generateWorld(int width, int height, int depth) {
        GeneratorSpaceGrid source = generateGrid(width, height, depth);
        LayeredSpaceGrid world = new LayeredSpaceGrid(width, height, depth);
        doGenerateWorld(source, world);
        return world;
    }
}
