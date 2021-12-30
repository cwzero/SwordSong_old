package com.liquidforte.song.grid.event;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public class DefaultGridRemoveEvent<P extends Point, S extends Size<P>, V> extends AbstractGridRemoveEvent<P, S, V> {
    public DefaultGridRemoveEvent(Grid<P, S, V> source, P point, V removed) {
        super(source, point, removed);
    }
}
