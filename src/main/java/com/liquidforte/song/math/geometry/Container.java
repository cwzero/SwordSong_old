package com.liquidforte.song.math.geometry;

import java.util.function.Function;

public interface Container<P extends Point<P>> extends ReferenceSpace<P> {
    boolean contains(P p);

    @Override
    default Function<P, P> externalToInternal() {
        return p -> contains(p) ? p : null;
    }

    @Override
    default Function<P, P> internalToExternal() {
        return p -> contains(p) ? p : null;
    }

    default Container<P> inverse() {
        return p -> !contains(p);
    }
}
