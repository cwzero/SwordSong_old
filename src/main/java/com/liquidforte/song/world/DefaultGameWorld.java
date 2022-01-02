package com.liquidforte.song.world;

import com.liquidforte.song.tilegrid.three.DefaultTileGrid3D;

public class DefaultGameWorld extends DefaultTileGrid3D implements GameWorld {
    public final int width, height, depth;

    public DefaultGameWorld(int width, int height, int depth) {
        super(width, height, depth);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getDepth() {
        return depth;
    }
}
