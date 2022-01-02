package com.liquidforte.song.tile;

import com.liquidforte.song.util.TextureUtil;
import com.liquidforte.song.util.TileUtil;

import java.awt.image.BufferedImage;

public record BasicCharTile(char tile) implements CharTile {
    public BasicCharTile(byte tile) {
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

    @Override
    public boolean isSolid() {
        return false;
    }
}
