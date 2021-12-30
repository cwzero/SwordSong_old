package com.liquidforte.song.grid.event;

import com.liquidforte.song.event.Event;
import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public interface GridEvent<P extends Point, S extends Size<P>, V> extends Event {
    Grid<P, S, V> getGrid();
}
