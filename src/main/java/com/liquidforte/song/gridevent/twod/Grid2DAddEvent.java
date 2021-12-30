package com.liquidforte.song.gridevent.twod;

import com.liquidforte.song.geometry.Grid2D;
import com.liquidforte.song.geometry.Point2D;

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
