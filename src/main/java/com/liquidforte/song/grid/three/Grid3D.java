package com.liquidforte.song.grid.three;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.Constrain;
import com.liquidforte.song.math.geometry.Offset;
import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.PointSet3D;
import com.liquidforte.song.math.geometry.three.Size3D;

import java.util.function.Function;
import java.util.function.Predicate;

public interface Grid3D<V> extends Grid<Point3D, V>, PointSet3D {
    default V setValue(int x, int y, int z, V v) {
        return setValue(new Point3D(x, y, z), v);
    }

    default V getValue(int x, int y, int z) {
        return getValue(new Point3D(x, y, z));
    }

    @Override
    Grid3D<V> map(Function<Point3D, Point3D> mapFn);

    @Override
    Grid3D<V> filter(Predicate<Point3D> filterFn);

    @Override
    default Grid3D<V> offset(Offset<Point3D> offset) {
        return map(offset);
    }

    @Override
    default Grid3D<V> offset(int x, int y, int z) {
        return offset(new Point3D(x, y, z));
    }

    @Override
    default Grid3D<V> constrain(Constrain<Point3D> constrain) {
        return filter(constrain);
    }

    @Override
    default Grid3D<V> constrain(int width, int height, int depth) {
        return constrain(new Size3D(width, height, depth));
    }
}
