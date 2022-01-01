package com.liquidforte.song.tilegrid.two;

import com.liquidforte.song.grid.two.AbstractGrid2D;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.PointSet2D;
import com.liquidforte.song.tile.Tile;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class AbstractTileGrid2D extends AbstractGrid2D<Tile> implements TileGrid2D {
    public AbstractTileGrid2D() {

    }

    public AbstractTileGrid2D(PointSet2D space) {
        super(space);
    }

    @Override
    public TileGrid2D map(Function<Point2D, Point2D> mapFn) {
        var result = new DelegateTileGrid2D(space.map(mapFn));
        addListener(result::fireEvent);
        return result;
    }

    @Override
    public TileGrid2D filter(Predicate<Point2D> filterFn) {
        var result = new DelegateTileGrid2D(space.filter(filterFn));
        addListener(result::fireEvent);
        return result;
    }

    protected class DelegateTileGrid2D extends AbstractTileGrid2D {
        public DelegateTileGrid2D(PointSet2D space) {
            super(space);
        }

        @Override
        public Tile setValue(Point2D p, Tile tile) {
            return AbstractTileGrid2D.this.setValue(construct(p), tile);
        }

        @Override
        protected Tile doSetValue(Point2D p, Tile tile) {
            return AbstractTileGrid2D.this.setValue(p, tile);
        }

        @Override
        public Tile getValue(Point2D p) {
            return AbstractTileGrid2D.this.getValue(construct(p));
        }

        @Override
        protected Tile doGetValue(Point2D p) {
            return AbstractTileGrid2D.this.getValue(p);
        }
    }
}
