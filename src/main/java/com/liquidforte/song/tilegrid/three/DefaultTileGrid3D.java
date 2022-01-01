package com.liquidforte.song.tilegrid.three;

import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.PointSet3D;
import com.liquidforte.song.tile.Tile;

import java.util.function.Function;
import java.util.function.Predicate;

public class DefaultTileGrid3D extends AbstractTileGrid3D {
    private final Tile[][][] grid;

    public DefaultTileGrid3D(int width, int height, int depth) {
        this(Point3D.space.constrain(width, height, depth), new Tile[width][height][depth]);
    }

    public DefaultTileGrid3D(PointSet3D space, Tile[][][] grid) {
        super(space);
        this.grid = grid;
    }

    @Override
    protected Tile doSetValue(Point3D p, Tile tile) {
        Tile oldValue = grid[p.x()][p.y()][p.z()];
        grid[p.x()][p.y()][p.z()] = tile;
        return oldValue;
    }

    @Override
    protected Tile doGetValue(Point3D p) {
        return grid[p.x()][p.y()][p.z()];
    }

    @Override
    public TileGrid3D map(Function<Point3D, Point3D> mapFn) {
        return new DefaultTileGrid3D(space.map(mapFn), grid);
    }

    @Override
    public TileGrid3D filter(Predicate<Point3D> filterFn) {
        return new DefaultTileGrid3D(space.filter(filterFn), grid);
    }
}
