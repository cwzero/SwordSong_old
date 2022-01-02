package com.liquidforte.song.tile;

import java.awt.image.BufferedImage;

public interface Tile {
    boolean isSolid();

    BufferedImage getTexture();
}
