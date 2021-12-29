package com.liquidforte.song.space;

import com.liquidforte.song.block.Block;
import com.liquidforte.song.tile.LayeredTile;
import com.liquidforte.song.tile.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class Space extends Block {
    private final Runnable update;
    private Tile foreground;
    private Stack<Tile> middle = new Stack<>();
    private Tile background;

    public Space(Runnable update) {
        this.update = update;
    }

    private synchronized void update() {
        setTile(new LayeredTile(getLayers()));
        update.run();
    }

    private Tile[] getLayers() {
        List<Tile> layers = new ArrayList<>();

        if (foreground != null) {
            layers.add(foreground);
        } else if (!middle.isEmpty()) {
            layers.add(middle.peek());
        }

        if (background != null) {
            layers.add(background);
        }

        return layers.toArray(new Tile[0]);
    }

    private boolean checkDirty(Tile oldTile, Tile newTile) {
        return (oldTile != null && oldTile.equals(newTile)) || (oldTile == null && newTile != null);
    }

    public void setForeground(Tile foreground) {
        if (checkDirty(this.foreground, foreground)) {
            this.foreground = foreground;
            update();
        }
    }

    public void pushMiddle(Tile middle) {
        this.middle.push(middle);
        if (foreground == null) {
            update();
        }
    }

    public void removeMiddle(Tile middle) {
        boolean dirty = foreground == null && this.middle.peek().equals(middle);
        this.middle.remove(middle);
        if (dirty) {
            update();
        }
    }

    public synchronized void setBackground(Tile background) {
        if (checkDirty(this.background, background)) {
            this.background = background;
            update();
        }
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
