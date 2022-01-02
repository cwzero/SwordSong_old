package com.liquidforte.song.tile;

import com.liquidforte.song.util.TextureUtil;
import com.liquidforte.song.util.TileUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public record BasicColoredTile(boolean solid, char tile, Color color) implements CharTile, ColoredTile {
    public BasicColoredTile(boolean solid, byte tile, Color color) {
        this(solid, TileUtil.decodeTile(tile), color);
    }
    public BasicColoredTile(byte tile, Color color) {
        this(true, tile, color);
    }

    public BasicColoredTile(CharTile source, Color color) {
        this(source.isSolid(), source.getTile(), color);
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

    @Override
    public boolean isSolid() {
        return solid;
    }
}
