package com.liquidforte.song.grid.event;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public abstract class AbstractGridEvent<P extends Point, S extends Size<P>, V> implements GridEvent<P, S, V> {
    private final Grid<P, S, V> source;

    // Either call the source constructor or override getSource
    public AbstractGridEvent() {
        this.source = null;
    }

    public AbstractGridEvent(Grid<P, S, V> source) {
        this.source = source;
    }

    @Override
    public Grid<P, S, V> getSource() {
        return source;
    }
}
