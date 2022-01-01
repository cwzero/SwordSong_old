package com.liquidforte.song.grid.two;

import com.liquidforte.song.grid.AbstractGrid;
import com.liquidforte.song.grid.event.GridEvent;
import com.liquidforte.song.grid.event.GridEvent2D;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.PointSet2D;

public abstract class AbstractGrid2D<V> extends AbstractGrid<Point2D, V> implements Grid2D<V> {
    private final PointSet2D space;

    public AbstractGrid2D() {
        this(input -> input);
    }

    public AbstractGrid2D(PointSet2D space) {
        this.space = space;
    }

    @Override
    protected GridEvent<Point2D, V> constructEvent(Point2D location, V oldValue, V newValue) {
        return new GridEvent2D<>(this, location, oldValue, newValue);
    }

    @Override
    public Point2D construct(Point2D input) {
        return space.construct(input);
    }
}
