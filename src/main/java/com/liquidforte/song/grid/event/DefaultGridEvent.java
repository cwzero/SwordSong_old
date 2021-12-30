package com.liquidforte.song.grid.event;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public class DefaultGridEvent<P extends Point, S extends Size<P>, V> extends AbstractGridEvent<P, S, V> {
    public DefaultGridEvent(Grid<P, S, V> source) {
        super(source);
    }
}
