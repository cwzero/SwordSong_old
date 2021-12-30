package com.liquidforte.oldsong.geometry;

public interface Dest<P extends Point, V> extends Source<P, V> {
    V set(P p, V v);
}
