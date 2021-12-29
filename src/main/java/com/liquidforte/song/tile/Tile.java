package com.liquidforte.song.tile;

import com.liquidforte.song.grid.Drawable;
import com.liquidforte.song.grid.TileGridAccess;
import com.liquidforte.song.util.TextureUtil;
import com.liquidforte.song.util.TileUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile implements Drawable {
    private final char tile;
    private final Color color;
    private final boolean solid;
    private final boolean empty;

    public Tile(Tile source) {
        this.tile = source.tile;
        this.color = source.color;
        this.solid = source.solid;
        this.empty = source.empty;
    }

    public Tile(Tile source, char tile) {
        this.tile = tile;
        this.color = source.color;
        this.solid = source.solid;
        this.empty = source.empty;
    }

    public Tile(Tile source, Color color) {
        this.tile = source.tile;
        this.color = color;
        this.solid = source.solid;
        this.empty = source.empty;
    }

    public Tile(Tile source, char tile, Color color) {
        this.tile = tile;
        this.color = color;
        this.solid = source.solid;
        this.empty = source.empty;
    }

    public Tile(Tile source, char tile, Color color, boolean solid) {
        this.tile = tile;
        this.color = color;
        this.solid = solid;
        this.empty = source.empty;
    }

    public Tile(Tile source, char tile, Color color, boolean solid, boolean empty) {
        this.tile = tile;
        this.color = color;
        this.solid = solid;
        this.empty = empty;
    }

    public Tile(char tile, Color color) {
        this.tile = tile;
        this.color = color;
        this.solid = true;
        this.empty = false;
    }

    public Tile(char tile, Color color, boolean solid) {
        this.tile = tile;
        this.color = color;
        this.solid = solid;
        this.empty = false;
    }

    public Tile(char tile, Color color, boolean solid, boolean empty) {
        this.tile = tile;
        this.color = color;
        this.solid = solid;
        this.empty = empty;
    }

    public Tile(Tile source, byte tile) {
        this.tile = TileUtil.decodeTile(tile);
        this.color = source.color;
        this.solid = source.solid;
        this.empty = source.empty;
    }

    public Tile(Tile source, byte tile, Color color) {
        this.tile = TileUtil.decodeTile(tile);
        this.color = color;
        this.solid = source.solid;
        this.empty = source.empty;
    }

    public Tile(Tile source, byte tile, Color color, boolean solid) {
        this.tile = TileUtil.decodeTile(tile);
        this.color = color;
        this.solid = solid;
        this.empty = source.empty;
    }

    public Tile(Tile source, byte tile, Color color, boolean solid, boolean empty) {
        this.tile = TileUtil.decodeTile(tile);
        this.color = color;
        this.solid = solid;
        this.empty = empty;
    }

    public Tile(byte tile, Color color) {
        this.tile = TileUtil.decodeTile(tile);
        this.color = color;
        this.solid = true;
        this.empty = false;
    }

    public Tile(byte tile, Color color, boolean solid) {
        this.tile = TileUtil.decodeTile(tile);
        this.color = color;
        this.solid = solid;
        this.empty = false;
    }

    public Tile(byte tile, Color color, boolean solid, boolean empty) {
        this.tile = TileUtil.decodeTile(tile);
        this.color = color;
        this.solid = solid;
        this.empty = empty;
    }

    public char getTile() {
        return tile;
    }

    public Color getColor() {
        return color;
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isSolid() {
        return solid;
    }

    public BufferedImage getTexture() {
        return TextureUtil.getTexture(color, tile);
    }

    public static Tile create(int x, int y) {
        return new Tile(TileUtil.decodeTile(x, y), Color.white);
    }

    public static Tile create(int x, int y, Color color) {
        return new Tile(TileUtil.decodeTile(x, y), color);
    }

    @Override
    public void draw(TileGridAccess grid, int x, int y) {
        grid.setTile(this, x, y);
    }
}
