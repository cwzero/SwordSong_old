package com.liquidforte.oldsong.gridevent.twod;

import com.liquidforte.oldsong.geometry.twod.Grid2D;
import com.liquidforte.oldsong.geometry.twod.Point2D;

public class Grid2DRemoveEvent<G extends Grid2D<G, V>, V> extends Grid2DPointEvent<G, V> {
    private final V removed;

    public Grid2DRemoveEvent(G grid, Point2D point, V removed) {
        super(grid, point);
        this.removed = removed;
    }

    public V getRemoved() {
        return removed;
    }
}
