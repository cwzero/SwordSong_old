package com.liquidforte.song.grid.two;

/*
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.Size2D;

public abstract class AbstractArrayGrid2D<V> extends AbstractGrid2D<V> {
    private final V[][] grid;

    public AbstractArrayGrid2D(V[][] grid) {
        this.grid = grid;
    }

    @Override
    protected V doGetValue(Point2D point) {
        return grid[point.x()][point.y()];
    }

    @Override
    protected V doPutValue(Point2D point, V v) {
        V current = grid[point.x()][point.y()];
        grid[point.x()][point.y()] = v;
        return current;
    }

    @Override
    public Size2D getSize() {
        return new Size2D(grid.length, grid[0].length);
    }
}
*/