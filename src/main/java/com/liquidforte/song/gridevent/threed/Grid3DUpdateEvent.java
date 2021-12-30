package com.liquidforte.song.gridevent.threed;

import com.liquidforte.song.geometry.Grid3D;
import com.liquidforte.song.geometry.Point3D;

public class Grid3DUpdateEvent<G extends Grid3D<G, V>, V> extends Grid3DPointEvent<G, V> {
    private final V removed;
    private final V added;

    public Grid3DUpdateEvent(G grid, Point3D point, V removed, V added) {
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
