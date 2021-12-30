package com.liquidforte.song.grid.two;

import com.liquidforte.song.grid.AbstractGrid;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.Size2D;

public abstract class AbstractGrid2D<V> extends AbstractGrid<Point2D, Size2D, V> implements Grid2D<V> {
    @Override
    protected V doGet(Object key) {
        if (key instanceof Point2D p){
            return getValue(p);
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        if (key instanceof Point2D p) {
            return removeKey(p);
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key instanceof Point2D p) {
            return contains(p);
        }
        return false;
    }
}
