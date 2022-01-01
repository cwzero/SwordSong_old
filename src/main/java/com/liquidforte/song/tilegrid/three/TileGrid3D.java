package com.liquidforte.song.tilegrid.three;

import com.liquidforte.song.grid.three.Grid3D;
import com.liquidforte.song.math.geometry.Constrain;
import com.liquidforte.song.math.geometry.Offset;
import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.Size3D;
import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.tilegrid.TileGrid;

import java.util.function.Function;
import java.util.function.Predicate;

public interface TileGrid3D extends TileGrid<Point3D>, Grid3D<Tile> {
    @Override
    TileGrid3D map(Function<Point3D, Point3D> mapFn);

    @Override
    default TileGrid3D offset(Offset<Point3D> offset) {
        return map(offset);
    }

    @Override
    default TileGrid3D offset(int x, int y, int z) {
        return offset(new Point3D(x, y, z));
    }

    @Override
    TileGrid3D filter(Predicate<Point3D> filterFn);

    @Override
    default TileGrid3D constrain(Constrain<Point3D> constrain) {
        return filter(constrain);
    }

    @Override
    default TileGrid3D constrain(int width, int height, int depth) {
        return constrain(new Size3D(width, height, depth));
    }
}
