package com.liquidforte.song.grid;

import com.liquidforte.song.grid.event.*;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

@SuppressWarnings("unchecked")
public class AbstractDelegatingGrid<P extends Point<P>, S extends Size<P, S>, V> extends AbstractGrid<P, S, V> {
    private final Grid<P, S, V> delegate;

    public AbstractDelegatingGrid() {
        this.delegate = null;
        getDelegate().addGridListener(new DelegateListener());
    }

    public AbstractDelegatingGrid(Grid<P, S, V> delegate) {
        this.delegate = delegate;
        delegate.addGridListener(new DelegateListener());
    }

    protected Grid<P, S, V> getDelegate() {
        return delegate;
    }

    @Override
    protected V doGet(Object key) {
        return getDelegate().get(key);
    }

    @Override
    protected V doGetValue(P p) {
        return getDelegate().get(p);
    }

    @Override
    protected V doPutValue(P p, V v) {
        return getDelegate().put(p, v);
    }

    @Override
    public V remove(Object key) {
        return getDelegate().remove(key);
    }

    @Override
    public boolean containsKey(Object key) {
        return getDelegate().containsKey(key);
    }

    @Override
    public S getSize() {
        return getDelegate().getSize();
    }

    private class DelegateListener implements GridListener<P, S, V> {
        @Override
        public void handleGridEvent(GridEvent<P, S, V> event) {
            if (event instanceof GridUpdateEvent e) {
                fireGridUpdateEvent(e);
            } else if (event instanceof GridAddEvent e) {
                fireGridAddEvent(e);
            } else if (event instanceof GridRemoveEvent e) {
                fireGridRemoveEvent(e);
            } else if (event instanceof GridPointEvent e) {
                fireGridPointEvent(e);
            } else {
                fireGridEvent(event);
            }
        }
    }
}
