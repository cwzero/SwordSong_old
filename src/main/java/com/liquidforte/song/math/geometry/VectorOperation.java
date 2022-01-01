package com.liquidforte.song.math.geometry;

import java.util.function.BiFunction;

@FunctionalInterface
public interface VectorOperation<V extends Vector, I, O> extends BiFunction<V, I, O> {

}
