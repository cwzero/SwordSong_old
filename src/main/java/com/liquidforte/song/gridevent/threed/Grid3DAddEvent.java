package com.liquidforte.song.gridevent.threed;

import com.liquidforte.song.geometry.threed.Grid3D;
import com.liquidforte.song.geometry.threed.Point3D;

public class Grid3DAddEvent<G extends Grid3D<G, V>, V> extends Grid3DPointEvent<G, V> {
    private final V added;

    public Grid3DAddEvent(G grid, Point3D point, V added) {
        super(grid, point);
        this.added = added;
    }

    public V getAdded() {
        return added;
    }
}
