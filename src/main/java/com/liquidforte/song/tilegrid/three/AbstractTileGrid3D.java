package com.liquidforte.song.tilegrid.three;

import com.liquidforte.song.grid.three.AbstractGrid3D;
import com.liquidforte.song.math.geometry.three.PointSet3D;
import com.liquidforte.song.tile.Tile;

public abstract class AbstractTileGrid3D extends AbstractGrid3D<Tile> implements TileGrid3D {
    public AbstractTileGrid3D() {

    }

    public AbstractTileGrid3D(PointSet3D space) {
        super(space);
    }
}
