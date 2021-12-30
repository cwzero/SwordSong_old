package com.liquidforte.song.math.geometry;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public interface Size<P extends Point<P>, S extends Size<P, S>> extends Vector<S>, Sized<P, S> {
    default Set<P> getPointSet() {
        return getPointStream().collect(Collectors.toSet());
    }

    Stream<P> getPointStream();

    @Override
    default S getSize() {
        return (S) this;
    }
}
