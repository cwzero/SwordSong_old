package com.liquidforte.song.grid;

import com.liquidforte.song.collect.Map;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.PointSet;

// TODO: write our own map interface - partially done already with source/dest and pointers
// TODO: do any of source/dest and pointers need to be tweaked for the vector library?
public interface Grid<P extends Point<P>, V> extends Map<P, V>, PointSet<P> {

}
