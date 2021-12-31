package com.liquidforte.song.grid.three;

import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.Size3D;
/*
public abstract class AbstractArrayGrid3D<V> extends AbstractGrid3D<V> {
    private final V[][][] grid;

    public AbstractArrayGrid3D(V[][][] grid) {
        this.grid = grid;
    }

    @Override
    protected V doGetValue(Point3D point) {
        return grid[point.x()][point.y()][point.z()];
    }

    @Override
    protected V doPutValue(Point3D point, V v) {
        V current = grid[point.x()][point.y()][point.z()];
        grid[point.x()][point.y()][point.z()] = v;
        return current;
    }

    @Override
    public Size3D getSize() {
        return new Size3D(grid.length, grid[0].length, grid[0][0].length);
    }
}
*/