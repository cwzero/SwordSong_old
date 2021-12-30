package com.liquidforte.oldsong.grid;

import com.liquidforte.oldsong.event.GridUpdateEvent;
import com.liquidforte.oldsong.event.GridTileUpdateEvent;
import com.liquidforte.oldsong.event.GridUpdateListener;
import com.liquidforte.oldsong.tile.Tile;

public class DelegatingTileGrid extends AbstractTileGrid implements GridUpdateListener {
    private final TileGridView delegate;

    public DelegatingTileGrid(TileGridView delegate) {
        this.delegate = delegate;
        delegate.addListener(this);
    }

    @Override
    public boolean filter(GridUpdateEvent event) {
        return event instanceof GridTileUpdateEvent e && contains(e.x, e.y);
    }

    @Override
    public void gridUpdate(GridUpdateEvent event) {
        fireUpdate(event);
    }

    @Override
    protected Tile doGetTile(int x, int y) {
        return delegate.getTile(x, y);
    }

    @Override
    protected Tile doSetTile(Tile tile, int x, int y) {
        return delegate.setTile(tile, x, y);
    }

    @Override
    public int getWidth() {
        return delegate.getWidth();
    }

    @Override
    public int getHeight() {
        return delegate.getHeight();
    }
}
