package com.liquidforte.oldsong.tilegrid;

import com.liquidforte.oldsong.tile.Tile;

public class DelegatingTileGrid2D<G extends TileGrid2D<G, T>, T extends Tile> extends AbstractDelegatingTileGrid2D<G, T> {
    private final G delegate;

    public DelegatingTileGrid2D(G delegate) {
        this.delegate = delegate;
    }

    @Override
    public G getDelegate() {
        return delegate;
    }
}
