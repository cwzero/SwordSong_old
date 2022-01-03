package com.liquidforte.song.tile;

import com.liquidforte.song.block.RoomBlock;

import java.awt.*;

public class StackTile extends AbstractTile {
    private AbstractTile foreground = null;
    private AbstractTile background = null;

    public AbstractTile getForeground() {
        return foreground;
    }

    public void setForeground(AbstractTile foreground) {
        this.foreground = foreground;
    }

    public AbstractTile getBackground() {
        return background;
    }

    public void setBackground(AbstractTile background) {
        this.background = background;
    }

    @Override
    public void draw(Graphics2D graphics, int x, int y) {
        AbstractTile foreground = getForeground();
        boolean fore = foreground != null;

        AbstractTile background = getBackground();
        if (background != null) {
            if (fore && background instanceof RoomBlock b) {
                b.smooth().draw(graphics, x, y);
            } else {
                background.draw(graphics, x, y);
            }
        }

        if (foreground != null) {
            foreground.draw(graphics, x, y);
        }
    }

    @Override
    public boolean isSolid() {
        return (getForeground() != null && getForeground().isSolid()) ||
                (getBackground() != null && getBackground().isSolid());
    }
}
