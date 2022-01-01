package com.liquidforte.song.tilegrid.three;

import com.liquidforte.song.grid.three.Grid3D;
import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.tilegrid.TileGrid;
import com.liquidforte.song.tilegrid.two.TileGrid2D;

import java.util.function.Function;
import java.util.function.Predicate;

public interface TileGrid3D extends TileGrid<Point3D>, Grid3D<Tile> {
    TileGrid2D getLayer(int z);

    @Override
    TileGrid3D map(Function<Point3D, Point3D> mapFn);

    @Override
    TileGrid3D filter(Predicate<Point3D> filterFn);
}
