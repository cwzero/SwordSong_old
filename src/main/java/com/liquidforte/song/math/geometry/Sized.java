package com.liquidforte.song.math.geometry;

public interface Sized<P extends Point<P>, S extends Size<P, S>> {
    S getSize();

    boolean contains(P point);
}
