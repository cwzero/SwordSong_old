package com.liquidforte.song.grid.two;

import com.liquidforte.song.grid.Grid;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.PointSet2D;

public interface Grid2D<G extends Grid2D<G, V>, V> extends Grid<G, Point2D, V>, PointSet2D<G> {

}
