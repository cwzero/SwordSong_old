package com.liquidforte.song.math.geometry;

import java.util.stream.Stream;

/*
    A bidirectional function between two different point representations in the same dimension
    A cuboid with its own reference space
 */
public interface Area<P extends Point<P>, S extends Size<P, S>> extends Cuboid<P, S> {
    P getInternalOffset();

    P transformExternal(P p);

    P transformInternal(P p);

    boolean containsExternal(P p);

    boolean containsInternal(P p);

    Stream<P> streamExternal();

    Stream<P> streamInternal();

    @Override
    default boolean contains(P point) {
        return containsInternal(point);
    }
}
