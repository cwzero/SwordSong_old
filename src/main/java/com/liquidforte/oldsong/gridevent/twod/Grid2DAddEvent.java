package com.liquidforte.oldsong.gridevent.twod;

import com.liquidforte.oldsong.geometry.twod.Grid2D;
import com.liquidforte.oldsong.geometry.twod.Point2D;

public class Grid2DAddEvent<G extends Grid2D<G, V>, V> extends Grid2DPointEvent<G, V> {
    private final V added;

    public Grid2DAddEvent(G grid, Point2D point, V added) {
        super(grid, point);
        this.added = added;
    }

    public V getAdded() {
        return added;
    }
}