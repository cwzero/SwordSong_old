package com.liquidforte.song.tilegrid.two;

import com.liquidforte.song.grid.two.Grid2D;
import com.liquidforte.song.math.geometry.Constrain;
import com.liquidforte.song.math.geometry.Offset;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.Size2D;
import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.tilegrid.TileGrid;

import java.util.function.Function;
import java.util.function.Predicate;

public interface TileGrid2D extends TileGrid<Point2D>, Grid2D<Tile> {
    @Override
    TileGrid2D map(Function<Point2D, Point2D> mapFn);

    @Override
    TileGrid2D filter(Predicate<Point2D> filterFn);

    @Override
    default TileGrid2D offset(Offset<Point2D> offset) {
        return map(offset);
    }

    @Override
    default TileGrid2D offset(int x, int y) {
        return offset(new Point2D(x, y));
    }

    @Override
    default TileGrid2D constrain(Constrain<Point2D> constrain) {
        return filter(constrain);
    }

    @Override
    default TileGrid2D constrain(int width, int height) {
        return constrain(new Size2D(width, height));
    }
}
