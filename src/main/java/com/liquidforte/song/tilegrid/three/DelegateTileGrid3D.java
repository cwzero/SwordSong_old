package com.liquidforte.song.tilegrid.three;


import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.PointSet3D;
import com.liquidforte.song.tile.Tile;

public class DelegateTileGrid3D extends AbstractTileGrid3D {
    private final TileGrid3D delegate;

    public DelegateTileGrid3D(TileGrid3D delegate, PointSet3D space) {
        super(space);
        this.delegate = delegate;
    }

    @Override
    public Tile setValue(Point3D p, Tile tile) {
        return delegate.setValue(construct(p), tile);
    }

    @Override
    protected Tile doSetValue(Point3D p, Tile tile) {
        return delegate.setValue(p, tile);
    }

    @Override
    public Tile getValue(Point3D p) {
        return delegate.getValue(construct(p));
    }

    @Override
    protected Tile doGetValue(Point3D p) {
        return delegate.getValue(p);
    }
}
