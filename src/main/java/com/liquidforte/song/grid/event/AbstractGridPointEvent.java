package com.liquidforte.song.grid.event;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public class AbstractGridPointEvent<P extends Point, S extends Size<P>, V> extends AbstractGridEvent<P, S, V> implements GridPointEvent<P, S, V> {
    private final P point;

    public AbstractGridPointEvent() {
        super();
        this.point = null;
    }

    public AbstractGridPointEvent(Grid<P, S, V> source) {
        super(source);
        this.point = null;
    }

    public AbstractGridPointEvent(P point) {
        super();
        this.point = point;
    }

    public AbstractGridPointEvent(Grid<P, S, V> source, P point) {
        super(source);
        this.point = point;
    }

    @Override
    public P getPoint() {
        return point;
    }
}
