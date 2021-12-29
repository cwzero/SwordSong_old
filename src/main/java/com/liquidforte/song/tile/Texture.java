package com.liquidforte.song.tile;

import com.liquidforte.song.util.TextureUtil;
import com.liquidforte.song.util.TileUtil;

import java.awt.image.BufferedImage;

// TODO: could this be a record?
public class Texture implements Tile {
    private final char tile;

    public Texture(Texture source) {
        this.tile = source.tile;
    }

    public Texture(char tile) {
        this.tile = tile;
    }

    public Texture(byte tile) {
        this.tile = TileUtil.decodeTile(tile);
    }

    public char getTile() {
        return tile;
    }

    @Override
    public BufferedImage getTexture() {
        return TextureUtil.getTexture(tile);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Texture texture)) return false;

        return tile == texture.tile;
    }

    @Override
    public int hashCode() {
        return tile;
    }
}
