package com.liquidforte.song.grid;

import com.liquidforte.song.event.AbstractEventSource;
import com.liquidforte.song.event.EventListener;
import com.liquidforte.song.grid.event.GridEvent;
import com.liquidforte.song.math.geometry.Point;

public abstract class AbstractGrid<P extends Point, V> extends AbstractEventSource implements Grid<P, V> {
    protected abstract V doSetValue(P p, V v);

    protected abstract V doGetValue(P p);

    protected abstract GridEvent<P, V> constructEvent(P location, V oldValue, V newValue);

    @Override
    public V setValue(P p, V v) {
        p = construct(p);
        if (p == null) return null;
        V oldValue = getValue(p);
        V newValue = doSetValue(p, v);
        // TODO: how to propagate to children
        fireEvent(EventListener.class, EventListener::filterEvent, EventListener::handleEvent, constructEvent(p, oldValue, newValue));
        return newValue;
    }

    @Override
    public V getValue(P p) {
        p = construct(p);
        if (p == null) return null;
        return doGetValue(p);
    }
}
