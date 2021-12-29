package com.liquidforte.song.tile;

import com.liquidforte.song.event.TileUpdateEvent;
import com.liquidforte.song.event.TileUpdateListener;

import javax.swing.event.EventListenerList;
import java.awt.image.BufferedImage;

public class TileContainer implements Tile, ListenTile, TileUpdateListener {
    private final EventListenerList listeners = new EventListenerList();
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
        for (TileUpdateListener listener : listeners.getListeners(TileUpdateListener.class)) {
            listener.updateTile(event);
        }
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        if (this.tile instanceof ListenTile l) {
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
        this.listeners.add(TileUpdateListener.class, listener);
    }

    @Override
    public void removeUpdateListener(TileUpdateListener listener) {
        this.listeners.remove(TileUpdateListener.class, listener);
    }
}
