package com.liquidforte.song.grid.event;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public class DefaultGridAddEvent<P extends Point<P>, S extends Size<P, S>, V> extends AbstractGridAddEvent<P, S, V> {
    public DefaultGridAddEvent(Grid<P, S, V> source, P point, V added) {
        super(source, point, added);
    }
}
