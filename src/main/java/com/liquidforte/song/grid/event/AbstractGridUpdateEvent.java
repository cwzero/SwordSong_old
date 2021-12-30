package com.liquidforte.song.grid.event;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public abstract class AbstractGridUpdateEvent<P extends Point, S extends Size<P>, V> extends AbstractGridPointEvent<P, S, V> implements GridUpdateEvent<P, S, V> {
    private final V removed;
    private final V added;

    public AbstractGridUpdateEvent() {
        this.removed = null;
        this.added = null;
    }

    public AbstractGridUpdateEvent(Grid<P, S, V> source) {
        super(source);
        this.removed = null;
        this.added = null;
    }

    public AbstractGridUpdateEvent(P point) {
        super(point);
        this.removed = null;
        this.added = null;
    }

    public AbstractGridUpdateEvent(Grid<P, S, V> source, P point) {
        super(source, point);
        this.removed = null;
        this.added = null;
    }

    public AbstractGridUpdateEvent(V removed, V added) {
        this.removed = removed;
        this.added = added;
    }

    public AbstractGridUpdateEvent(Grid<P, S, V> source, V removed, V added) {
        super(source);
        this.removed = removed;
        this.added = added;
    }

    public AbstractGridUpdateEvent(P point, V removed, V added) {
        super(point);
        this.removed = removed;
        this.added = added;
    }

    public AbstractGridUpdateEvent(Grid<P, S, V> source, P point, V removed, V added) {
        super(source, point);
        this.removed = removed;
        this.added = added;
    }

    @Override
    public V getRemoved() {
        return removed;
    }

    @Override
    public V getAdded() {
        return added;
    }
}
