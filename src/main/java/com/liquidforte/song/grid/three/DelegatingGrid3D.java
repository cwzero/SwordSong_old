package com.liquidforte.song.grid.three;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.Size3D;

public class DelegatingGrid3D<V> extends AbstractDelegatingGrid3D<V> {
    public DelegatingGrid3D(Grid<Point3D, Size3D, V> delegate) {
        super(delegate);
    }
}
