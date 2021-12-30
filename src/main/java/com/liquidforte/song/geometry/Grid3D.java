package com.liquidforte.song.geometry;

import com.liquidforte.song.gridevent.threed.Grid3DEventSource;
import com.liquidforte.song.pointer.Dest3D;

import java.util.Map;

public interface Grid3D<G extends Grid3D<G, V>, V> extends Map<Point3D, V>, Dest3D<V>, Grid3DEventSource<G, V> {
    int getWidth();

    int getHeight();

    int getDepth();

    default Size3D getSize() {
        return new Size3D(getWidth(), getHeight(), getDepth());
    }

    V get(int x, int y, int z);

    @Override
    default V set(int x, int y, int z, V v) {
        return put(x, y, z, v);
    }

    @Override
    default V get(Object key) {
        if (key instanceof Point3D p) {
            return get(p.x(), p.y(), p.z());
        }
        return null;
    }

    V put(int x, int y, int z, V v);

    @Override
    default V put(Point3D key, V value) {
        return put(key.x(), key.y(), key.z(), value);
    }

    int getMinX();

    int getMaxX();

    int getMinY();

    int getMaxY();

    int getMinZ();

    int getMaxZ();

    boolean containsKey(int x, int y, int z);

    @Override
    default boolean containsKey(Object key) {
        if (key instanceof Point3D p) {
            return containsKey(p.x(), p.y(), p.z());
        }
        return false;
    }
}
