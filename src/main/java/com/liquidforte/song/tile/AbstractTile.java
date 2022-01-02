package com.liquidforte.song.tile;

import com.liquidforte.song.util.TextureUtil;
import com.liquidforte.song.util.TileUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class AbstractTile {
    protected BufferedImage texture;
    protected boolean solid = true;

    public AbstractTile(boolean solid) {
        this.solid = solid;
    }

    public AbstractTile(byte tile, Color color, boolean solid) {
        this(TileUtil.decodeTile(tile), color, solid);
    }

    public AbstractTile(char tile, Color color, boolean solid) {
        this(TextureUtil.getTexture(color, tile), solid);
    }

    public AbstractTile(BufferedImage texture, boolean solid) {
        this.texture = texture;
        this.solid = solid;
    }

    public AbstractTile() {

    }

    public AbstractTile(byte tile, Color color) {
        this(TileUtil.decodeTile(tile), color);
    }

    public AbstractTile(char tile, Color color) {
        this(TextureUtil.getTexture(color, tile));
    }

    public AbstractTile(BufferedImage texture) {
        this.texture = texture;
    }

    public boolean isSolid() {
        return solid;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void draw(Graphics2D graphics, int x, int y) {
        BufferedImage texture = getTexture();
        if (texture != null) {
            graphics.drawImage(texture, x * 16, y * 16, null);
        }
    }
}
