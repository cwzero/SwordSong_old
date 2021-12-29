package com.liquidforte.song.entity;

import com.liquidforte.song.block.Block;
import com.liquidforte.song.space.LayeredSpaceGrid;
import com.liquidforte.song.space.Space;
import com.liquidforte.song.tile.ColoredTile;

import java.awt.*;

public class MovableEntity extends Block {
    private final LayeredSpaceGrid world;
    private int x, y, z;
    private final ColoredTile tile;
    private boolean placed = false;

    public MovableEntity(LayeredSpaceGrid world, ColoredTile tile) {
        this(world, tile, true);
    }

    public MovableEntity(LayeredSpaceGrid world, ColoredTile tile, boolean solid) {
        super(tile, solid);
        this.world = world;
        this.tile = tile;
    }

    public void setColor(Color color) {
        tile.setColor(color);
    }

    public Color getColor() {
        return tile.getColor();
    }

    public Space getSpace() {
        return world.getSpaceLayer(z).createSpace(x, y);
    }

    public boolean canExit() {
        Space current = getSpace();
        return placed && current != null && current.getForeground() != null && current.getForeground().equals(this);
    }

    public boolean isPlaced() {
        Space current = getSpace();
        return placed && current != null && current.getForeground() != null && current.getForeground().equals(this);
    }

    public boolean canMoveTo(int x, int y, int z) {
        return canMoveTo(world.getSpaceLayer(z).createSpace(x, y));
    }

    public boolean canMoveTo(Space space) {
        return space != null && !space.isSolid();
    }

    public boolean canEnter(Space space) {
        return !isPlaced() && canMoveTo(space);
    }

    public boolean moveTo(int x, int y, int z) {
        if (canMoveTo(x, y, z) && remove()) {
            this.x = x;
            this.y = y;
            this.z = z;
            return place();
        }
        return false;
    }

    public boolean staggerAny() {
        if (moveNorth()) {
            return moveSouth();
        } else if (moveEast()) {
            return moveWest();
        } else if (moveSouth()) {
            return moveNorth();
        } else if (moveWest()) {
            return moveEast();
        }
        return false;
    }

    public boolean moveNorth() {
        return moveTo(x, y-1, z);
    }

    public boolean moveEast() {
        return moveTo(x+1, y, z);
    }

    public boolean moveSouth() {
        return moveTo(x, y+1, z);
    }

    public boolean moveWest() {
        return moveTo(x-1, y, z);
    }

    public boolean place() {
        if (remove()) {
            Space space = getSpace();
            if (canEnter(space)) {
                space.setForeground(this);
                fireUpdate();
                placed = true;
                return true;
            }
        }
        return false;
    }

    public boolean remove() {
        if (!placed) {
            return true;
        }
        if (canExit()) {
            // TODO: space layers - entities can live in foreground or background
            getSpace().clearForeground();
            fireUpdate();
            placed = false;
            return true;
        }
        return false;
    }
}
