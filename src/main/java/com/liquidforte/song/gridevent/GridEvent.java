package com.liquidforte.song.gridevent;

import com.liquidforte.song.geometry.Grid;
import com.liquidforte.song.geometry.Point;

public interface GridEvent<P extends Point, V> {
    Grid<P, V> getGrid();
}
