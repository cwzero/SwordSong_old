package com.liquidforte.song.math.geometry;

import java.util.function.Function;

@FunctionalInterface
public interface Offset<V extends Vector> extends Function<V, V> {

}
