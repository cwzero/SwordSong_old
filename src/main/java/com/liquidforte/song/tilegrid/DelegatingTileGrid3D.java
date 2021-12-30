package com.liquidforte.song.tilegrid;

import com.liquidforte.song.tile.Tile;

public class DelegatingTileGrid3D<G extends TileGrid3D<G, T>, T extends Tile> extends AbstractDelegatingTileGrid3D<G, T> {
    private final G delegate;

    public DelegatingTileGrid3D(G delegate) {
        this.delegate = delegate;
    }

    @Override
    protected G getDelegate() {
        return delegate;
    }
}
