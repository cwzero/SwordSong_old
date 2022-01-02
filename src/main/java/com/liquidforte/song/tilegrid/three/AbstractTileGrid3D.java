package com.liquidforte.song.tilegrid.three;

import com.liquidforte.song.event.EventListener;
import com.liquidforte.song.grid.event.GridEvent2D;
import com.liquidforte.song.grid.event.GridEvent3D;
import com.liquidforte.song.grid.three.AbstractGrid3D;
import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.PointSet3D;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.tilegrid.two.AbstractTileGrid2D;
import com.liquidforte.song.tilegrid.two.TileGrid2D;

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
        var result = new DelegateTileGrid3D(this, space.map(mapFn));
        addListener(new EventListener() {
            @Override
            public void handleEvent(Object event) {
                result.fireEvent(event);
            }

            @Override
            public boolean filterEvent(Object event) {
                if (event instanceof GridEvent3D e) {
                    return result.construct(e.getLocation()) != null;
                }
                return false;
            }
        });
        return result;
    }

    @Override
    public TileGrid3D filter(Predicate<Point3D> filterFn) {
        var result = new DelegateTileGrid3D(this, space.filter(filterFn));
        addListener(new EventListener() {
            @Override
            public void handleEvent(Object event) {
                result.fireEvent(event);
            }

            @Override
            public boolean filterEvent(Object event) {
                if (event instanceof GridEvent3D e) {
                    return result.construct(e.getLocation()) != null;
                }
                return false;
            }
        });
        return result;
    }

    @Override
    public TileGrid2D getLayer(int z) {
        var result = new AbstractTileGrid2D(Point2D.space) {
            @Override
            protected Tile doSetValue(Point2D point2D, Tile tile) {
                return AbstractTileGrid3D.this.setValue(new Point3D(point2D.x(), point2D.y(), z), tile);
            }

            @Override
            protected Tile doGetValue(Point2D point2D) {
                return AbstractTileGrid3D.this.getValue(new Point3D(point2D.x(), point2D.y(), z));
            }
        };
        addListener(new EventListener() {
            @Override
            public void handleEvent(Object event) {
                if (event instanceof GridEvent3D e) {
                    result.fireEvent(new GridEvent2D<>(result, new Point2D(e.getLocation().x(), e.getLocation().y()), (Tile)e.getOldValue(), (Tile)e.getNewValue()));
                }
            }

            @Override
            public boolean filterEvent(Object event) {
                if (event instanceof GridEvent3D e) {
                    return result.construct(e.getLocation().x(), e.getLocation().y()) != null;
                }
                return false;
            }
        });
        return result;
    }
}
