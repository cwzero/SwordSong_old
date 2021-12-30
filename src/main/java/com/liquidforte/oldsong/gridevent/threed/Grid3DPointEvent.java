package com.liquidforte.oldsong.gridevent.threed;

import com.liquidforte.oldsong.geometry.threed.Grid3D;
import com.liquidforte.oldsong.geometry.threed.Point3D;

public class Grid3DPointEvent<G extends Grid3D<G, V>, V> extends Grid3DEvent<G, V> {
    private final Point3D point;

    public Grid3DPointEvent(G grid, Point3D point) {
        super(grid);
        this.point = point;
    }

    public Point3D getPoint() {
        return point;
    }
}
