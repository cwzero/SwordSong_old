package com.liquidforte.song.tile;

import com.liquidforte.song.event.AbstractEventSource;

import java.awt.image.BufferedImage;
import java.util.Stack;

public class StackTile extends AbstractEventSource implements Tile, Block {
    private Tile foreground = null;
    private final Stack<Tile> contents = new Stack<>();
    private Tile background = null;

    public static StackTile background(Tile tile) {
        StackTile result = new StackTile();
        result.setBackground(tile);
        return result;
    }

    public static StackTile foreground(Tile tile) {
        StackTile result = new StackTile();
        result.setForeground(tile);
        return result;
    }

    public StackTile() {

    }

    @Override
    public BufferedImage getTexture() {
        if (foreground != null) {
            return foreground.getTexture();
        } else if (!contents.isEmpty()) {
            return contents.peek().getTexture();
        } else if (background != null) {
            return background.getTexture();
        }
        return null;
    }

    public void setForeground(Tile foreground) {
        this.foreground = foreground;
    }

    public Tile getForeground() {
        return foreground;
    }

    public void setBackground(Tile background) {
        this.background = background;
    }

    public Tile getBackground() {
        return background;
    }

    public void push(Tile tile) {
        contents.push(tile);
    }

    public boolean isEmpty() {
        return contents.isEmpty() && foreground == null && background == null;
    }

    public Tile pop() {
        return contents.pop();
    }

    @Override
    public boolean isSolid() {
        return (foreground == null && background == null) ||
                (foreground != null && foreground.isSolid()) ||
                (background != null && background.isSolid());
    }
}
