package com.liquidforte.song.math.geometry;

import java.util.function.BiFunction;

@FunctionalInterface
public interface VectorSetOperation<V extends Vector, S extends VectorSet<V>, C> extends BiFunction<S, C, S> {

}
