package com.liquidforte.song.math.geometry;

public interface VectorSpace<V extends Vector, S extends VectorSet<V>> extends VectorSet<V>, VectorOperations<V>, VectorSetOperations<V, S> {

}
