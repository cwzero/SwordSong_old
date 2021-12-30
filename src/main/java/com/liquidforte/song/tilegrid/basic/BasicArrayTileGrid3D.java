package com.liquidforte.song.tilegrid.basic;

import com.liquidforte.song.geometry.Array3DCreator;
import com.liquidforte.song.geometry.Size3D;
import com.liquidforte.song.tile.Tile;

public class BasicArrayTileGrid3D extends AbstractBasicArrayTileGrid3D {
    public BasicArrayTileGrid3D(int width, int height, int depth) {
        super(width, height, depth);
    }

    public BasicArrayTileGrid3D(Size3D size) {
        super(size);
    }

    public BasicArrayTileGrid3D(int width, int height, int depth, Array3DCreator<Tile> creator) {
        super(width, height, depth, creator);
    }

    public BasicArrayTileGrid3D(Size3D size, Array3DCreator<Tile> creator) {
        super(size, creator);
    }

    public BasicArrayTileGrid3D(Tile[][][] grid) {
        super(grid);
    }
}
