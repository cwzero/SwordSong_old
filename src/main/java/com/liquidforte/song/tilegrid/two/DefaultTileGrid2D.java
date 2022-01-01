package com.liquidforte.song.tilegrid.two;

import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.PointSet2D;
import com.liquidforte.song.tile.Tile;

import java.util.function.Function;
import java.util.function.Predicate;

public class DefaultTileGrid2D extends AbstractTileGrid2D {
    private final Tile[][] grid;

    public DefaultTileGrid2D(int width, int height) {
        this(Point2D.space.constrain(width, height), new Tile[width][height]);
    }

    public DefaultTileGrid2D(PointSet2D space, Tile[][] grid) {
        super(space);
        this.grid = grid;
    }

    @Override
    protected Tile doSetValue(Point2D p, Tile tile) {
        Tile oldValue = grid[p.x()][p.y()];
        grid[p.x()][p.y()] = tile;
        return oldValue;
    }

    @Override
    protected Tile doGetValue(Point2D p) {
        return grid[p.x()][p.y()];
    }

    @Override
    public TileGrid2D map(Function<Point2D, Point2D> mapFn) {
        return new DefaultTileGrid2D(space.map(mapFn), grid);
    }

    @Override
    public TileGrid2D filter(Predicate<Point2D> filterFn) {
        return new DefaultTileGrid2D(space.filter(filterFn), grid);
    }
}