package com.liquidforte.song.tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LayeredTile implements Tile {
    public final Tile[] layers;
    private final BufferedImage texture;

    public LayeredTile(Tile... layers) {
        this.layers = layers;
        texture = new BufferedImage(16, 16, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D graphics = texture.createGraphics();

        for (int i = layers.length - 1; i >= 0; i--) {
            graphics.drawImage(layers[i].getTexture(), 0, 0, null);
        }
    }

    @Override
    public BufferedImage getTexture() {
        return texture;
    }
}
