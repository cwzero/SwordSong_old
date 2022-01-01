package com.liquidforte.song.tile;

import com.liquidforte.song.util.TextureUtil;
import com.liquidforte.song.util.TileUtil;

import java.awt.image.BufferedImage;

public record BasicTile(char tile) implements CharTile {
    public BasicTile(byte tile) {
        this(TileUtil.decodeTile(tile));
    }

    @Override
    public char getTile() {
        return tile;
    }

    @Override
    public BufferedImage getTexture() {
        return TextureUtil.getTexture(tile);
    }
}
