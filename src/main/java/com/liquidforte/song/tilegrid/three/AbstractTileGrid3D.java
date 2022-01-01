package com.liquidforte.song.tilegrid.three;

import com.liquidforte.song.grid.three.AbstractGrid3D;
import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.PointSet3D;
import com.liquidforte.song.tile.Tile;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class AbstractTileGrid3D extends AbstractGrid3D<Tile> implements TileGrid3D {
    public AbstractTileGrid3D() {

    }

    public AbstractTileGrid3D(PointSet3D space) {
        super(space);
    }

    @Override
    public TileGrid3D map(Function<Point3D, Point3D> mapFn) {
        var result = new DelegateTileGrid3D(space.map(mapFn));
        addListener(result::fireEvent);
        return result;
    }

    @Override
    public TileGrid3D filter(Predicate<Point3D> filterFn) {
        var result = new DelegateTileGrid3D(space.filter(filterFn));
        addListener(result::fireEvent);
        return result;
    }

    protected class DelegateTileGrid3D extends AbstractTileGrid3D {
        public DelegateTileGrid3D(PointSet3D space) {
            super(space);
        }

        @Override
        public Tile setValue(Point3D p, Tile tile) {
            return AbstractTileGrid3D.this.setValue(construct(p), tile);
        }

        @Override
        protected Tile doSetValue(Point3D p, Tile tile) {
            return AbstractTileGrid3D.this.setValue(p, tile);
        }

        @Override
        public Tile getValue(Point3D p) {
            return AbstractTileGrid3D.this.getValue(construct(p));
        }

        @Override
        protected Tile doGetValue(Point3D p) {
            return AbstractTileGrid3D.this.getValue(p);
        }
    }
}
