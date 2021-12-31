package com.liquidforte.song.grid;

import com.liquidforte.song.collect.Map;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.PointSet;

// TODO: write our own map interface - partially done already with source/dest and pointers
// TODO: do any of source/dest and pointers need to be tweaked for the vector library?
// TODO: when we call get, set, the grid calls construct with the passed in point
public interface Grid<G extends Grid<G, P, V>, P extends Point<P>, V> extends Map<P, V>, PointSet<G, P> {
    default V setValue(int[] components, V v) {
        return setValue(construct(components), v);
    }

    default V setValue(V v, int... components) {
        return setValue(components, v);
    }

    default V getValue(int... components) {
        return getValue(construct(components));
    }
}
