package com.liquidforte.song.math.geometry;

import java.util.function.Function;

/*
    A bidirectional function mapping points from an external reference space into an internal one
    A cuboid plus a function to turn an external point into the arbitrary internal representation
 */
public class Space {
    public static <P extends Point<P>> ReferenceSpace<P> getSpace(Class<P> pointClass) {
        return new ReferenceSpace<>() {
            @Override
            public Function<P, P> externalToInternal() {
                return p -> p;
            }

            @Override
            public Function<P, P> internalToExternal() {
                return p -> p;
            }

            @Override
            public ReferenceSpace<P> inverse() {
                return getSpace(pointClass);
            }
        };
    }
}
