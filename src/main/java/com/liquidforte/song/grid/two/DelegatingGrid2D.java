package com.liquidforte.song.grid.two;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.Size2D;

public class DelegatingGrid2D<V> extends AbstractDelegatingGrid2D<V> {
    public DelegatingGrid2D(Grid<Point2D, Size2D, V> delegate) {
        super(delegate);
    }
}
