package com.liquidforte.song.math.geometry;

import java.util.stream.Stream;

/*
    A bidirectional function between two different point representations in the same dimension
    A cuboid with its own reference space
 */
public interface Area<P extends Point, S extends Size<P>> extends Cuboid<P, S> {
    P getInternalOffset();

    P transformEnter(P p);

    P transformExit(P p);

    boolean containsExternal(P p);

    boolean containsInternal(P p);

    Stream<P> streamExternal();

    Stream<P> streamInternal();
}
