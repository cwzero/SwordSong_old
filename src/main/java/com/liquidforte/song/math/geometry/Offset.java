package com.liquidforte.song.math.geometry;

import java.util.function.Function;

/*
    A bidirectional transformation between arbitrary reference spaces
    A reference space defined by adding an offset
 */
public interface Offset<P extends Point<P>> extends ReferenceSpace<P> {
    P getOffset();

    @Override
    default Function<P, P> internalToExternal() {
        return getOffset()::add;
    }

    @Override
    default Function<P, P> externalToInternal() {
        return getOffset()::subtract;
    }

    default Offset<P> inverse() {
        return () -> getOffset().invert();
    }
}
