package com.liquidforte.song.grid.event;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public class DefaultGridPointEvent<P extends Point, S extends Size<P>, V> extends AbstractGridPointEvent<P, S, V> {
    public DefaultGridPointEvent(Grid<P, S, V> source, P point) {
        super(source, point);
    }
}
