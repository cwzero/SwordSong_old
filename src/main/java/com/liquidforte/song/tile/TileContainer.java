package com.liquidforte.song.tile;

import java.awt.image.BufferedImage;

public class TileContainer implements Tile {
    private Tile tile;

    public TileContainer() {

    }

    public TileContainer(Tile tile) {
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    @Override
    public BufferedImage getTexture() {
        Tile tile = getTile();
        if (tile == null) return null;
        return tile.getTexture();
    }
}
