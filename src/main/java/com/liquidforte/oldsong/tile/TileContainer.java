package com.liquidforte.oldsong.tile;

import com.liquidforte.oldsong.event.TileUpdateEvent;
import com.liquidforte.oldsong.event.TileUpdateListener;
import com.liquidforte.oldsong.event.AbstractEventSource;

import java.awt.image.BufferedImage;

public class TileContainer extends AbstractEventSource implements Tile, ListenTile, TileUpdateListener {
    private Tile tile;

    public TileContainer() {

    }

    public TileContainer(Tile tile) {
        this.tile = tile;
        if (tile instanceof ListenTile l) {
            l.addUpdateListener(this);
        }
    }

    protected void fireUpdate() {
        fireUpdate(new TileUpdateEvent(this));
    }

    protected void fireUpdate(TileUpdateEvent event) {
        fireEvent(TileUpdateListener.class, TileUpdateListener::filterEvent, TileUpdateListener::updateTile, event);
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        if (getTile() instanceof ListenTile l) {
            l.removeUpdateListener(this);
        }
        this.tile = tile;
        if (tile instanceof ListenTile l) {
            l.addUpdateListener(this);
        }
        fireUpdate();
    }

    @Override
    public BufferedImage getTexture() {
        Tile tile = getTile();
        if (tile == null) return null;
        return tile.getTexture();
    }

    @Override
    public void updateTile(TileUpdateEvent event) {
        fireUpdate();
    }

    @Override
    public void addUpdateListener(TileUpdateListener listener) {
        addListener(TileUpdateListener.class, listener);
    }

    @Override
    public void removeUpdateListener(TileUpdateListener listener) {
        removeListener(TileUpdateListener.class, listener);
    }
}
