package com.liquidforte.song.tile;

import com.liquidforte.song.event.TileUpdateEvent;
import com.liquidforte.song.event.TileUpdateListener;
import com.liquidforte.song.util.Colorizer;
import com.liquidforte.song.util.TextureUtil;

import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class ColoredTile implements Tile, ListenTile {
    private final EventListenerList listeners = new EventListenerList();
    private final Tile source;
    private Color color;
    private BufferedImage texture;

    public ColoredTile(byte tile, Color color) {
        this(new Texture(tile), color);
    }

    public ColoredTile(char tile, Color color) {
        this(new Texture(tile), color);
    }

    public ColoredTile(Tile source, Color color) {
        if (source instanceof TileContainer c) {
            source = c.getTile();
        }

        if (source instanceof ColoredTile t) {
            source = t.source;
        }

        this.source = source;
        this.color = color;
        update();
    }

    public void setColor(Color color) {
        this.color = color;
        update();
    }

    public Color getColor() {
        return color;
    }

    private void update() {
        if (source instanceof Texture t) {
            this.texture = TextureUtil.getTexture(color, t.getTile());
        } else if (source instanceof LayeredTile l) {
            Tile[] layers = Arrays.stream(l.layers)
                    .map(it -> {
                        if (it instanceof ColoredTile t && t.color == Color.black) {
                            return it;
                        } else {
                            return new ColoredTile(it, color);
                        }
                    })
                    .toArray(Tile[]::new);
            this.texture = new LayeredTile(layers).getTexture();
        } else {
            this.texture = Colorizer.colorize(source.getTexture(), color);
        }
        fireUpdate();
    }

    protected void fireUpdate() {
        fireUpdate(new TileUpdateEvent(this));
    }

    protected void fireUpdate(TileUpdateEvent event) {
        for (TileUpdateListener listener : listeners.getListeners(TileUpdateListener.class)) {
            listener.updateTile(event);
        }
    }

    @Override
    public BufferedImage getTexture() {
        return texture;
    }

    @Override
    public void addUpdateListener(TileUpdateListener listener) {
        listeners.add(TileUpdateListener.class, listener);
    }

    @Override
    public void removeUpdateListener(TileUpdateListener listener) {
        listeners.remove(TileUpdateListener.class, listener);
    }
}
