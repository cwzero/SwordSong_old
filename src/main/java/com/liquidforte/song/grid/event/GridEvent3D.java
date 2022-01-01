package com.liquidforte.song.grid.event;

import com.liquidforte.song.grid.three.Grid3D;
import com.liquidforte.song.math.geometry.three.Point3D;

public class GridEvent3D<V> implements GridEvent<Point3D, V> {
    private final Grid3D<V> grid;
    private final Point3D location;
    private final V oldValue;
    private final V newValue;

    public GridEvent3D(Grid3D<V> grid, Point3D location, V oldValue, V newValue) {
        this.grid = grid;
        this.location = location;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public Grid3D<V> getGrid() {
        return grid;
    }

    @Override
    public Point3D getLocation() {
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
