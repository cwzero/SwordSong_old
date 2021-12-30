package com.liquidforte.oldsong.pointer;

import com.liquidforte.oldsong.geometry.threed.Point3D;

public interface Source3D<V> {
    V get(int x, int y, int z);

    Pointer3D<V> getPointer(Point3D pos);

    default Pointer3D<V> getPointer(int x, int y, int z) {
        return getPointer(new Point3D(x, y, z));
    }

    default V get(Point3D pos) {
        return get(pos.x(), pos.y(), pos.z());
    }

    default V get(Positional3D target) {
        return get(target.getX(), target.getY(), target.getZ());
    }
}
