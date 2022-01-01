package com.liquidforte.song.grid.event;

import com.liquidforte.song.grid.two.Grid2D;
import com.liquidforte.song.math.geometry.two.Point2D;

public class GridEvent2D<V> implements GridEvent<Point2D, V> {
    private final Grid2D<V> grid;
    private final Point2D location;
    private final V oldValue;
    private final V newValue;

    public GridEvent2D(Grid2D<V> grid, Point2D location, V oldValue, V newValue) {
        this.grid = grid;
        this.location = location;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public Grid2D<V> getGrid() {
        return grid;
    }

    @Override
    public Point2D getLocation() {
        return location;
    }

    @Override
    public V getOldValue() {
        return oldValue;
    }

    @Override
    public V getNewValue() {
        return newValue;
    }
}
