package com.liquidforte.song.math.geometry;

/*
    Root interface for things that act within an arbitrary reference space
 */
public interface Spatial<P extends Point<P>> {
    ReferenceSpace<P> getSpace();
}
