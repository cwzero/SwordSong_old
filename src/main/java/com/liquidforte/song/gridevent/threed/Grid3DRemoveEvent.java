package com.liquidforte.song.gridevent.threed;

import com.liquidforte.song.geometry.threed.Grid3D;
import com.liquidforte.song.geometry.threed.Point3D;

public class Grid3DRemoveEvent<G extends Grid3D<G, V>, V> extends Grid3DPointEvent<G, V> {
    private final V removed;

    public Grid3DRemoveEvent(G grid, Point3D point, V removed) {
        super(grid, point);
        this.removed = removed;
    }

    public V getRemoved() {
        return removed;
    }
}
