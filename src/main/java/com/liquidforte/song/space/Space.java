package com.liquidforte.song.space;

import com.liquidforte.song.block.Block;
import com.liquidforte.song.block.RoomBlock;
import com.liquidforte.song.event.TileUpdateEvent;
import com.liquidforte.song.tile.LayeredTile;
import com.liquidforte.song.tile.ListenTile;
import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.util.TileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class Space extends Block {
    private final Stack<Tile> middle = new Stack<>();

    private Tile foreground;
    private Tile background;

    @Override
    public void updateTile(TileUpdateEvent event) {
        setTile(new LayeredTile(getLayers()));
        super.updateTile(event);
    }

    private synchronized void update() {
        setTile(new LayeredTile(getLayers()));
        fireUpdate();
    }

    private Tile[] getLayers() {
        List<Tile> layers = new ArrayList<>();

        if (foreground != null) {
            layers.add(foreground);
            if (background instanceof RoomBlock b) {
                layers.add(b.smooth());
            }
        } else if (!middle.isEmpty()) {
            layers.add(middle.peek());
            if (background instanceof RoomBlock b) {
                layers.add(b.smooth());
            }
        } else if (background != null) {
            layers.add(background);
        }

        return layers.toArray(new Tile[0]);
    }

    public void setForeground(Tile foreground) {
        if (TileUtil.checkDirty(this.foreground, foreground)) {
            if (this.foreground instanceof ListenTile t) {
                t.removeUpdateListener(this);
            }
            this.foreground = foreground;
            if (foreground instanceof ListenTile t) {
                t.addUpdateListener(this);
            }
            update();
        }
    }

    public void clearForeground() {
        setForeground(null);
    }

    public Tile getForeground() {
        return foreground;
    }

    public void pushMiddle(Tile middle) {
        this.middle.push(middle);
        if (foreground == null) {
            update();
        }
    }

    public Stack<Tile> getMiddle() {
        return middle;
    }

    public void removeMiddle(Tile middle) {
        boolean dirty = foreground == null && this.middle.peek().equals(middle);
        this.middle.remove(middle);
        if (dirty) {
            update();
        }
    }

    public synchronized void setBackground(Tile background) {
        if (TileUtil.checkDirty(this.background, background)) {
            this.background = background;
            update();
        }
    }

    public void clearBackground() {
        setBackground(null);
    }

    public Tile getBackground() {
        return background;
    }

    protected Stream<Tile> stream() {
        Stream.Builder<Tile> builder = Stream.builder();

        if (foreground != null) {
            builder.add(foreground);
        }

        if (!middle.isEmpty()) {
            middle.forEach(builder::add);
        }

        if (background != null) {
            builder.add(background);
        }

        return builder.build();
    }

    @Override
    public boolean isSolid() {
        return stream().anyMatch(it -> it instanceof Block b && b.isSolid());
    }
}
