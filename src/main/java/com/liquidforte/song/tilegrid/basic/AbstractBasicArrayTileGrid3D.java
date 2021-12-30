package com.liquidforte.song.tilegrid.basic;

import com.liquidforte.song.geometry.Array3DCreator;
import com.liquidforte.song.geometry.Size3D;
import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.tilegrid.AbstractArrayTileGrid3D;

public abstract class AbstractBasicArrayTileGrid3D extends AbstractArrayTileGrid3D<BasicTileGrid3D, Tile> {
    public AbstractBasicArrayTileGrid3D(int width, int height, int depth) {
        this(width, height, depth, BasicTileArrayCreator3D.CREATOR);
    }

    public AbstractBasicArrayTileGrid3D(Size3D size) {
        this(size, BasicTileArrayCreator3D.CREATOR);
    }

    public AbstractBasicArrayTileGrid3D(int width, int height, int depth, Array3DCreator<Tile> creator) {
        super(width, height, depth, creator);
    }

    public AbstractBasicArrayTileGrid3D(Size3D size, Array3DCreator<Tile> creator) {
        super(size, creator);
    }

    public AbstractBasicArrayTileGrid3D(Tile[][][] grid) {
        super(grid);
    }
}
