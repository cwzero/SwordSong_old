package com.liquidforte.oldsong.tilegrid;

import com.liquidforte.oldsong.tile.Tile;
import com.liquidforte.oldsong.geometry.threed.AbstractArrayGrid3D;
import com.liquidforte.oldsong.geometry.threed.Array3DCreator;
import com.liquidforte.oldsong.geometry.threed.Size3D;

public abstract class AbstractArrayTileGrid3D<G extends TileGrid3D<G, T>, T extends Tile> extends AbstractArrayGrid3D<G, T> implements TileGrid3D<G, T> {
    public AbstractArrayTileGrid3D(int width, int height, int depth, Array3DCreator<T> creator) {
        super(width, height, depth, creator);
    }

    public AbstractArrayTileGrid3D(Size3D size, Array3DCreator<T> creator) {
        super(size, creator);
    }

    public AbstractArrayTileGrid3D(T[][][] grid) {
        super(grid);
    }
}
