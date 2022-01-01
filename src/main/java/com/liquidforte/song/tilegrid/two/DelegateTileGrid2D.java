package com.liquidforte.song.tilegrid.two;

import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.PointSet2D;
import com.liquidforte.song.tile.Tile;

public class DelegateTileGrid2D extends AbstractTileGrid2D {
    private final TileGrid2D delegate;

    public DelegateTileGrid2D(TileGrid2D delegate, PointSet2D space) {
        super(space);
        this.delegate = delegate;
    }

    @Override
    public Tile setValue(Point2D p, Tile tile) {
        return delegate.setValue(construct(p), tile);
    }

    @Override
    protected Tile doSetValue(Point2D point2D, Tile tile) {
        return null;
    }

    @Override
    public Tile getValue(Point2D p) {
        return delegate.getValue(construct(p));
    }

    @Override
    protected Tile doGetValue(Point2D point2D) {
        return null;
    }
}
