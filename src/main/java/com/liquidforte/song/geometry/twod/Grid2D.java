package com.liquidforte.song.geometry.twod;

import com.liquidforte.song.gridevent.twod.Grid2DEventSource;
import com.liquidforte.song.pointer.Dest2D;

import java.util.Map;

public interface Grid2D<G extends Grid2D<G, V>, V> extends Map<Point2D, V>, Dest2D<V>, Grid2DEventSource<G, V> {
    int getWidth();

    int getHeight();

    default Size2D getSize() {
        return new Size2D(getWidth(), getHeight());
    }

    V get(int x, int y);

    @Override
    default V get(Object key) {
        if (key instanceof Point2D p) {
            return get(p.x(), p.y());
        }
        return null;
    }

    V put(int x, int y, V v);

    @Override
    default V set(int x, int y, V v) {
        return put(x, y, v);
    }

    @Override
    default V put(Point2D key, V value) {
        return put(key.x(), key.y(), value);
    }

    int getMinX();

    int getMaxX();

    int getMinY();

    int getMaxY();

    boolean containsKey(int x, int y);

    @Override
    default boolean containsKey(Object key) {
        if (key instanceof Point2D p) {
            return containsKey(p.x(), p.y());
        }
        return false;
    }
}
