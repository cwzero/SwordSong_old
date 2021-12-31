package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.VectorSpace;

public interface VectorSpace3D<S extends VectorSet3D<S, V>, V extends Vector3D<V>> extends VectorSet3D<S, V>, VectorSpace<S, V> {

}
