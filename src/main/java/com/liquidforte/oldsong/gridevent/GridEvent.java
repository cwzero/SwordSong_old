package com.liquidforte.oldsong.gridevent;

import com.liquidforte.oldsong.geometry.Grid;
import com.liquidforte.oldsong.geometry.Point;

public interface GridEvent<P extends Point, V> {
    Grid<P, V> getGrid();
}
