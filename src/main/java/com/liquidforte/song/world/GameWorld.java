package com.liquidforte.song.world;

import com.liquidforte.song.tilegrid.three.TileGrid3D;

public interface GameWorld extends TileGrid3D {

    int getWidth();

    int getHeight();

    int getDepth();
}
