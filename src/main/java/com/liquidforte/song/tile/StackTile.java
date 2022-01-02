package com.liquidforte.song.tile;

import java.awt.*;

public class StackTile extends AbstractTile {
    private AbstractTile tile = null;

    public AbstractTile getTile() {
        return tile;
    }

    public void setTile(AbstractTile tile) {
        this.tile = tile;
    }

    @Override
    public void draw(Graphics2D graphics, int x, int y) {
        AbstractTile tile = getTile();
        if (tile != null) {
            tile.draw(graphics, x, y);
        }
    }

    @Override
    public boolean isSolid() {
        return getTile() != null && getTile().isSolid();
    }
}
