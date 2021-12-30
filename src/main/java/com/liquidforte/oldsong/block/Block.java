package com.liquidforte.oldsong.block;

import com.liquidforte.oldsong.tile.Tile;
import com.liquidforte.oldsong.tile.TileContainer;

public class Block extends TileContainer {
    private boolean solid = false;

    public Block() {

    }

    public Block(boolean solid) {
        this.solid = solid;
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
