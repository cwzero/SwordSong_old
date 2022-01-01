package com.liquidforte.song.world;

import com.liquidforte.song.tilegrid.three.DefaultTileGrid3D;

public class DefaultGameWorld extends DefaultTileGrid3D implements GameWorld {
    public DefaultGameWorld(int width, int height, int depth) {
        super(width, height, depth);
    }
}
