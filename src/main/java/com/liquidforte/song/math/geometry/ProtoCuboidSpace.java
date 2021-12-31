package com.liquidforte.song.math.geometry;

import java.util.function.Function;

public interface ProtoCuboidSpace<P extends Point<P>, S extends Size<P, S>> extends ReferenceSpace<P> {
    Offset<P> getExternalOffset();

    Container<P> getContainer();

    Offset<P> getInternalOffset();

    default ReferenceSpace<P> getSpace() {
        return getExternalOffset()
                .mapOnto(getContainer())
                .mapOnto(getInternalOffset());
    }

    @Override
    default Function<P, P> externalToInternal() {
        return getSpace().externalToInternal();
    }

    default Function<P, P> internalToExternal() {
        return getSpace().internalToExternal();
    }

    @Override
    default ReferenceSpace<P> inverse() {
        return getSpace().inverse();
    }
}
