package com.liquidforte.song.grid;

import com.liquidforte.song.collect.Map;
import com.liquidforte.song.event.EventSource;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.PointSet;

import java.util.function.Function;
import java.util.function.Predicate;

// TODO: write our own map interface - partially done already with source/dest and pointers
// TODO: do any of source/dest and pointers need to be tweaked for the vector library?
// TODO: when we call get, set, the grid calls construct with the passed in point
public interface Grid<P extends Point, V> extends EventSource, Map<P, V>, PointSet<P> {
    @Override
    Grid<P, V> map(Function<P, P> mapFn);

    @Override
    Grid<P, V> filter(Predicate<P> filterFn);
}
