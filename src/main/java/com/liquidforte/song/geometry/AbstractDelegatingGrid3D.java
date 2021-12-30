package com.liquidforte.song.geometry;

public abstract class AbstractDelegatingGrid3D<G extends Grid3D<G, V>, V> extends AbstractGrid3D<G, V> {
    protected abstract G getDelegate();

    public AbstractDelegatingGrid3D() {
        this(true);
    }

    public AbstractDelegatingGrid3D(boolean propagate) {
        if (propagate) {
            propagateEvents();
        }
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
    public int getDepth() {
        return getDelegate().getDepth();
    }

    @Override
    protected V doGet(int x, int y, int z) {
        return getDelegate().get(x, y, z);
    }

    @Override
    protected V doPut(int x, int y, int z, V v) {
        return getDelegate().put(x, y, z, v);
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
    public int getMinZ() {
        return getDelegate().getMinZ();
    }

    @Override
    public int getMaxZ() {
        return getDelegate().getMaxZ();
    }

    protected void propagateEvents() {
        propagateEvents(getDelegate());
    }
}
