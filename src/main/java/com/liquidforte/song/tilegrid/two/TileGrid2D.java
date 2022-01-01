package com.liquidforte.song.tilegrid.two;

import com.liquidforte.song.grid.two.Grid2D;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.tilegrid.TileGrid;

import java.util.function.Function;
import java.util.function.Predicate;

public interface TileGrid2D extends TileGrid<Point2D>, Grid2D<Tile> {
    @Override
    TileGrid2D map(Function<Point2D, Point2D> mapFn);

    @Override
    TileGrid2D filter(Predicate<Point2D> filterFn);
}
