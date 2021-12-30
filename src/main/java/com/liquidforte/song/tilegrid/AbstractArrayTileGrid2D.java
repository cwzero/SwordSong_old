package com.liquidforte.song.tilegrid;

import com.liquidforte.song.geometry.twod.AbstractArrayGrid2D;
import com.liquidforte.song.geometry.twod.Array2DCreator;
import com.liquidforte.song.geometry.twod.Size2D;
import com.liquidforte.song.tile.Tile;

public abstract class AbstractArrayTileGrid2D<G extends TileGrid2D<G, T>, T extends Tile> extends AbstractArrayGrid2D<G, T> implements TileGrid2D<G, T> {
    public AbstractArrayTileGrid2D(int width, int height, Array2DCreator<T> creator) {
        super(width, height, creator);
    }

    public AbstractArrayTileGrid2D(Size2D size, Array2DCreator<T> creator) {
        super(size, creator);
    }

    public AbstractArrayTileGrid2D(T[][] grid) {
        super(grid);
    }
}
