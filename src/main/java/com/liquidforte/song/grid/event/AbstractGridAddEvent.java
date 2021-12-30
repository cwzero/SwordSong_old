package com.liquidforte.song.grid.event;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public abstract class AbstractGridAddEvent<P extends Point, S extends Size<P>, V> extends AbstractGridPointEvent<P, S, V> implements GridAddEvent<P, S, V> {
    private final V added;

    public AbstractGridAddEvent() {
        this.added = null;
    }

    public AbstractGridAddEvent(Grid<P, S, V> source) {
        super(source);
        this.added = null;
    }

    public AbstractGridAddEvent(P point) {
        super(point);
        this.added = null;
    }

    public AbstractGridAddEvent(Grid<P, S, V> source, P point) {
        super(source, point);
        this.added = null;
    }

    public AbstractGridAddEvent(V added) {
        this.added = added;
    }

    public AbstractGridAddEvent(Grid<P, S, V> source, V added) {
        super(source);
        this.added = added;
    }

    public AbstractGridAddEvent(P point, V added) {
        super(point);
        this.added = added;
    }

    public AbstractGridAddEvent(Grid<P, S, V> source, P point, V added) {
        super(source, point);
        this.added = added;
    }

    @Override
    public V getAdded() {
        return added;
    }
}
