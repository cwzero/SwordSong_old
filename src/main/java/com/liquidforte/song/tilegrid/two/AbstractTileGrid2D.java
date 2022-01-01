package com.liquidforte.song.tilegrid.two;

import com.liquidforte.song.grid.two.AbstractGrid2D;
import com.liquidforte.song.math.geometry.two.PointSet2D;
import com.liquidforte.song.tile.Tile;

public abstract class AbstractTileGrid2D extends AbstractGrid2D<Tile> implements TileGrid2D {
    public AbstractTileGrid2D() {

    }

    public AbstractTileGrid2D(PointSet2D space) {
        super(space);
    }
}
