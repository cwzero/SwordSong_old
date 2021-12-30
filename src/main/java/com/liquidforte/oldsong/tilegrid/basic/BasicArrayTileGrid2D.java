package com.liquidforte.oldsong.tilegrid.basic;

import com.liquidforte.oldsong.geometry.twod.Array2DCreator;
import com.liquidforte.oldsong.geometry.twod.Size2D;
import com.liquidforte.oldsong.tile.Tile;

public class BasicArrayTileGrid2D extends AbstractBasicArrayTileGrid2D {
    public BasicArrayTileGrid2D(Size2D size) {
        super(size);
    }

    public BasicArrayTileGrid2D(int width, int height) {
        super(width, height);
    }

    public BasicArrayTileGrid2D(int width, int height, Array2DCreator<Tile> creator) {
        super(width, height, creator);
    }

    public BasicArrayTileGrid2D(Size2D size, Array2DCreator<Tile> creator) {
        super(size, creator);
    }

    public BasicArrayTileGrid2D(Tile[][] grid) {
        super(grid);
    }
}
