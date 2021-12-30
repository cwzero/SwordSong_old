package com.liquidforte.song.geometry;

public interface Source<P extends Point, V> {
    V get(P point);

    Pointer<V> getPointer(P point);
}
