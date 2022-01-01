package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.VectorSpace;

public interface VectorSpace3D<V extends Vector3D, S extends VectorSet3D<V>> extends VectorSet3D<V>, VectorSpace<V, S> {

}
