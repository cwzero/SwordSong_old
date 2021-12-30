package com.liquidforte.oldsong.tilegrid.basic;

import com.liquidforte.oldsong.geometry.twod.Array2DCreator;
import com.liquidforte.oldsong.geometry.twod.Size2D;
import com.liquidforte.oldsong.tile.Tile;
import com.liquidforte.oldsong.tilegrid.AbstractArrayTileGrid2D;

public abstract class AbstractBasicArrayTileGrid2D extends AbstractArrayTileGrid2D<BasicTileGrid2D, Tile> implements BasicTileGrid2D {
    public AbstractBasicArrayTileGrid2D(Size2D size) {
        this(size, BasicTileArrayCreator2D.CREATOR);
    }

    public AbstractBasicArrayTileGrid2D(int width, int height) {
        this(width, height, BasicTileArrayCreator2D.CREATOR);
    }

    public AbstractBasicArrayTileGrid2D(int width, int height, Array2DCreator<Tile> creator) {
        super(width, height, creator);
    }

    public AbstractBasicArrayTileGrid2D(Size2D size, Array2DCreator<Tile> creator) {
        super(size, creator);
    }

    public AbstractBasicArrayTileGrid2D(Tile[][] grid) {
        super(grid);
    }
}
