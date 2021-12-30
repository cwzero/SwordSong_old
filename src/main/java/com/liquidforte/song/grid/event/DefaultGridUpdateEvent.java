package com.liquidforte.song.grid.event;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public class DefaultGridUpdateEvent<P extends Point<P>, S extends Size<P, S>, V> extends AbstractGridUpdateEvent<P, S, V> {
    public DefaultGridUpdateEvent(Grid<P, S, V> source, P point, V removed, V added) {
        super(source, point, removed, added);
    }
}
