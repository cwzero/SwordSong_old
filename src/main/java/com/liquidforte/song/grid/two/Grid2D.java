package com.liquidforte.song.grid.two;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.PointSet2D;

import java.util.function.Function;
import java.util.function.Predicate;

public interface Grid2D<V> extends Grid<Point2D, V>, PointSet2D {
    default V setValue(int x, int y, V v) {
        return setValue(new Point2D(x, y), v);
    }

    default V getValue(int x, int y) {
        return getValue(new Point2D(x, y));
    }

    @Override
    Grid2D<V> map(Function<Point2D, Point2D> mapFn);

    @Override
    Grid2D<V> filter(Predicate<Point2D> filterFn);
}
