package com.liquidforte.song.gridevent.twod;

import com.liquidforte.song.geometry.twod.Grid2D;
import com.liquidforte.song.geometry.twod.Point2D;

public class Grid2DUpdateEvent<G extends Grid2D<G, V>, V> extends Grid2DPointEvent<G, V> {
    private final V removed;
    private final V added;

    public Grid2DUpdateEvent(G grid, Point2D point, V removed, V added) {
        super(grid, point);
        this.removed = removed;
        this.added = added;
    }

    public V getRemoved() {
        return removed;
    }

    public V getAdded() {
        return added;
    }
}
