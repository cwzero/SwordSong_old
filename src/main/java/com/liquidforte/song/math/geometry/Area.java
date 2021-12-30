package com.liquidforte.song.math.geometry;

import java.util.stream.Stream;

/*
    A bidirectional function between two different point representations in the same dimension
 */
public interface Area<P extends Point, S extends Size<P>> extends Located<P>, Sized<P, S> {
    P getExternalOffset();

    P getInternalOffset();

    @Override
    S getSize();

    P transformEnter(P p);

    P transformExit(P p);

    boolean containsExternal(P p);

    boolean containsInternal(P p);

    Stream<P> streamExternal();

    Stream<P> streamInternal();

    @Override
    default P getLocation() {
        return getExternalOffset();
    }
}
