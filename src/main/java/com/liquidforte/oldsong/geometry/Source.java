package com.liquidforte.oldsong.geometry;

public interface Source<P extends Point, V> {
    V get(P point);

    Pointer<V> getPointer(P point);
}
