package com.liquidforte.song.grid.event;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.Point;

public interface GridEvent<P extends Point, V> {
    Grid<P, V> getGrid();

    P getLocation();

    V getOldValue();

    V getNewValue();
}
