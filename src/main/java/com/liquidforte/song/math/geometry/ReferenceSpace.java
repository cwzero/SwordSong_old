package com.liquidforte.song.math.geometry;

import com.liquidforte.song.util.StreamUtil;

import java.util.function.Function;
import java.util.stream.Stream;

/*
    An invertible, bidirectional function mapping into and out of an arbitrary reference space
    It could be thought of as an arbitrary mapping from one coordinate system to another
    We can apply it onto the space of arbitrary points (our default n-dimensional grid) to use it as a coordinate system
    They can also be composed/mapped onto each other, and inverted
    The intent is to allow us to define arbitrary n-dimensional grids, with their own internal coordinate system
 */
public interface ReferenceSpace<P extends Point<P>> {
    Function<P, P> externalToInternal();

    default boolean containsExternal(P p) {
        return externalToInternal().apply(p) != null;
    }

    default Stream<P> mapExternalToInternal(Stream<P> external) {
        return StreamUtil.mapNonNull(external, externalToInternal());
    }

    Function<P, P> internalToExternal();

    default boolean containsInternal(P p) {
        return internalToExternal().apply(p) != null;
    }

    default Stream<P> mapInternalToExternal(Stream<P> internal) {
        return StreamUtil.mapNonNull(internal, internalToExternal());
    }

    default ReferenceSpace<P> mapOnto(ReferenceSpace<P> other) {
        return new ComposedSpace<>(this, other);
    }

    ReferenceSpace<P> inverse();

    record ComposedSpace<P extends Point<P>>(ReferenceSpace<P> source,
                                             ReferenceSpace<P> destination) implements ReferenceSpace<P> {
        @Override
        public Function<P, P> externalToInternal() {
            return source.externalToInternal().andThen(destination.externalToInternal());
        }

        @Override
        public Function<P, P> internalToExternal() {
            return destination.internalToExternal().andThen(source.internalToExternal());
        }

        @Override
        public ReferenceSpace<P> inverse() {
            return new ComposedSpace<>(source.inverse(), destination.inverse());
        }
    }
}
