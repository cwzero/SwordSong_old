package com.liquidforte.song.grid.three;

import com.liquidforte.song.grid.AbstractGrid;
import com.liquidforte.song.grid.event.GridEvent;
import com.liquidforte.song.grid.event.GridEvent3D;
import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.PointSet3D;

public abstract class AbstractGrid3D<V> extends AbstractGrid<Point3D, V> implements Grid3D<V> {
    private final PointSet3D space;

    public AbstractGrid3D() {
        this(input -> input);
    }

    public AbstractGrid3D(PointSet3D space) {
        this.space = space;
    }

    @Override
    protected GridEvent<Point3D, V> constructEvent(Point3D location, V oldValue, V newValue) {
        return new GridEvent3D<>(this, location, oldValue, newValue);
    }

    @Override
    public Point3D construct(Point3D input) {
        return space.construct(input);
    }
}
