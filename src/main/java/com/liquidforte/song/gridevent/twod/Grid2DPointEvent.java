package com.liquidforte.song.gridevent.twod;

import com.liquidforte.song.geometry.Grid2D;
import com.liquidforte.song.geometry.Point2D;

public class Grid2DPointEvent<G extends Grid2D<G, V>, V> extends Grid2DEvent<G, V> {
    private final Point2D point;

    public Grid2DPointEvent(G grid, Point2D point) {
        super(grid);
        this.point = point;
    }

    public Point2D getPoint() {
        return point;
    }
}
