package com.liquidforte.song.entity;

import com.liquidforte.song.space.LayeredSpaceGrid;
import com.liquidforte.song.space.Space;

import java.util.Objects;

public abstract class AbstractPositional implements Positional {
    private final LayeredSpaceGrid grid;
    private int x, y, z;

    public AbstractPositional(LayeredSpaceGrid grid) {
        this.grid = grid;
    }

    protected LayeredSpaceGrid getGrid() {
        return grid;
    }

    @Override
    public int getX() {
        return x;
    }

    protected void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }

    @Override
    public int getZ() {
        return z;
    }

    protected void setZ(int z) {
        this.z = z;
    }

    protected void setPosition(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Space getSpace() {
        return grid.getSpace(x, y, z);
    }

    protected Space createSpace() {
        return grid.createSpace(x, y, z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPositional that)) return false;
        return getX() == that.getX() && getY() == that.getY() && getZ() == that.getZ() && getGrid().equals(that.getGrid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGrid(), getX(), getY(), getZ());
    }
}
