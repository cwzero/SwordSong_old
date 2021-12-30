package com.liquidforte.oldsong.world;

import com.liquidforte.oldsong.grid.TileGrid;
import com.liquidforte.oldsong.grid.ArrayTileGrid;

import java.awt.*;
import java.util.function.Function;

public class LayeredGrid {
    private final int width, height, depth;
    private final TileGrid[] layers;

    public LayeredGrid(int width, int height, int depth, Function<Dimension, TileGrid> gridFunction) {
        this.layers = new TileGrid[depth];
        this.width = width;
        this.height = height;
        this.depth = depth;

        Dimension size = new Dimension(width, height);
        for (int i = 0; i < depth; i++) {
            layers[i] = gridFunction.apply(size);
        }
    }

    public LayeredGrid(int width, int height, int depth) {
        this.layers = new TileGrid[depth];
        this.width = width;
        this.height = height;
        this.depth = depth;

        for (int i = 0; i < depth; i++) {
            layers[i] = new ArrayTileGrid(width, height);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public TileGrid getLayer(int z) {
        if (z >= 0 && z < depth)
            return layers[z];
        return null;
    }
}
