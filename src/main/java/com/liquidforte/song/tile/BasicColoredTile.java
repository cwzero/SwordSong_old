package com.liquidforte.song.tile;

import com.liquidforte.song.util.TextureUtil;
import com.liquidforte.song.util.TileUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public record BasicColoredTile(char tile, Color color) implements CharTile, ColoredTile {
    public BasicColoredTile(byte tile, Color color) {
        this(TileUtil.decodeTile(tile), color);
    }

    public BasicColoredTile(CharTile source, Color color) {
        this(source.getTile(), color);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public char getTile() {
        return tile;
    }

    @Override
    public BufferedImage getTexture() {
        return TextureUtil.getTexture(color, tile);
    }
}
