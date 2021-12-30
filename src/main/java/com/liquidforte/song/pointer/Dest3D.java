package com.liquidforte.song.pointer;

import com.liquidforte.song.geometry.threed.Point3D;

public interface Dest3D<V> extends Source3D<V> {
    V set(int x, int y, int z, V v);

    default V set(Point3D pos, V v) {
        return set(pos.x(), pos.y(), pos.z(), v);
    }

    default V set(Positional3D pos, V v) {
        return set(pos.getX(), pos.getY(), pos.getZ(), v);
    }
}
