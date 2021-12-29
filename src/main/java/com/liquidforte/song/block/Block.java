package com.liquidforte.song.block;

import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.tile.TileContainer;

public class Block extends TileContainer {
    private boolean solid = false;

    public Block() {

    }

    public Block(boolean solid) {

    }

    public Block(Tile tile) {
        super(tile);
    }

    public Block(Tile tile, boolean solid) {
        super(tile);
        this.solid = solid;
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }
}
