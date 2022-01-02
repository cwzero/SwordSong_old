package com.liquidforte.song.tilegrid.two;

import com.liquidforte.song.event.EventListener;
import com.liquidforte.song.grid.event.GridEvent2D;
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
        var result = new DelegateTileGrid2D(this, Point2D.space.map(mapFn));
        addListener(new EventListener() {
            @Override
            public void handleEvent(Object event) {
                result.fireEvent(event);
            }

            @Override
            public boolean filterEvent(Object event) {
                if (event instanceof GridEvent2D e) {
                    return result.construct(e.getLocation()) != null;
                }
                return false;
            }
        });
        return result;
    }

    @Override
    public TileGrid2D filter(Predicate<Point2D> filterFn) {
        var result = new DelegateTileGrid2D(this, Point2D.space.filter(filterFn));
        addListener(new EventListener() {
            @Override
            public void handleEvent(Object event) {
                result.fireEvent(event);
            }

            @Override
            public boolean filterEvent(Object event) {
                if (event instanceof GridEvent2D e) {
                    return result.construct(e.getLocation()) != null;
                }
                return false;
            }
        });
        return result;
    }
}
