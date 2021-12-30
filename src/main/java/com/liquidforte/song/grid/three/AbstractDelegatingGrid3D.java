package com.liquidforte.song.grid.three;

import com.liquidforte.song.grid.AbstractDelegatingGrid;
import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.Size3D;

public abstract class AbstractDelegatingGrid3D<V> extends AbstractDelegatingGrid<Point3D, Size3D, V> implements Grid3D<V> {
    public AbstractDelegatingGrid3D() {

    }

    public AbstractDelegatingGrid3D(Grid<Point3D, Size3D, V> delegate) {
        super(delegate);
    }
}
