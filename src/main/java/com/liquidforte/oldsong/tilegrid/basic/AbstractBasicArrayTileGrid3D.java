package com.liquidforte.oldsong.tilegrid.basic;

import com.liquidforte.oldsong.geometry.threed.Array3DCreator;
import com.liquidforte.oldsong.geometry.threed.Size3D;
import com.liquidforte.oldsong.tile.Tile;
import com.liquidforte.oldsong.tilegrid.AbstractArrayTileGrid3D;

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
