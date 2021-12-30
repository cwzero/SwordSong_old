package com.liquidforte.song.grid.event;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public abstract class AbstractGridRemoveEvent<P extends Point<P>, S extends Size<P, S>, V> extends AbstractGridPointEvent<P, S, V> implements GridRemoveEvent<P, S, V> {
    private final V removed;

    public AbstractGridRemoveEvent() {
        this.removed = null;
    }

    public AbstractGridRemoveEvent(Grid<P, S, V> source) {
        super(source);
        this.removed = null;
    }

    public AbstractGridRemoveEvent(P point) {
        super(point);
        this.removed = null;
    }

    public AbstractGridRemoveEvent(Grid<P, S, V> source, P point) {
        super(source, point);
        this.removed = null;
    }

    public AbstractGridRemoveEvent(V removed) {
        this.removed = removed;
    }

    public AbstractGridRemoveEvent(Grid<P, S, V> source, V removed) {
        super(source);
        this.removed = removed;
    }

    public AbstractGridRemoveEvent(P point, V removed) {
        super(point);
        this.removed = removed;
    }

    public AbstractGridRemoveEvent(Grid<P, S, V> source, P point, V removed) {
        super(source, point);
        this.removed = removed;
    }

    @Override
    public V getRemoved() {
        return removed;
    }
}
