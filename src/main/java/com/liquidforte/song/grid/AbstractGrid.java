package com.liquidforte.song.grid;

import com.liquidforte.song.event.AbstractEventSource;
import com.liquidforte.song.math.geometry.Point;

public abstract class AbstractGrid<G extends Grid<G, P, V>, P extends Point<P>, V> extends AbstractEventSource implements Grid<G, P, V> {
    @Override
    public V setValue(P p, V v) {
        return doSetValue(construct(p), v);
    }

    protected abstract V doSetValue(P p, V v);

    @Override
    public V getValue(P p) {
        return doGetValue(construct(p));
    }

    protected abstract V doGetValue(P p);
}
