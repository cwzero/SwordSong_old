package com.liquidforte.song.geometry.twod;

public abstract class AbstractDelegatingGrid2D<G extends Grid2D<G, V>, V> extends AbstractGrid2D<G, V> {
    protected abstract G getDelegate();

    public AbstractDelegatingGrid2D() {
        this(true);
    }

    public AbstractDelegatingGrid2D(boolean propagate) {
        if (propagate) {
            propagateEvents();
        }
    }

    @Override
    public int getMinX() {
        return getDelegate().getMinX();
    }

    @Override
    public int getMaxX() {
        return getDelegate().getMaxX();
    }

    @Override
    public int getMinY() {
        return getDelegate().getMinY();
    }

    @Override
    public int getMaxY() {
        return getDelegate().getMaxY();
    }

    @Override
    public int getWidth() {
        return getDelegate().getWidth();
    }

    @Override
    public int getHeight() {
        return getDelegate().getHeight();
    }

    @Override
    protected V doGet(int x, int y) {
        return getDelegate().get(x, y);
    }

    @Override
    protected V doPut(int x, int y, V v) {
        return getDelegate().put(x, y, v);
    }

    protected void propagateEvents() {
        propagateEvents(getDelegate());
    }
}
