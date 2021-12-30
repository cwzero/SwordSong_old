package com.liquidforte.oldsong.entity;

import com.liquidforte.oldsong.space.LayeredSpaceGrid;
import com.liquidforte.oldsong.space.Space;

import java.util.Objects;

public class PositionPointer extends AbstractMovable implements Pointer {
    private final boolean solid;

    public PositionPointer(LayeredSpaceGrid world) {
        this(world, true);
    }

    public PositionPointer(LayeredSpaceGrid world, boolean solid) {
        super(world);
        this.solid = solid;
    }

    protected boolean isSpaceSolid() {
        return getSpace() != null && getSpace().isSolid();
    }

    protected boolean canMoveTo(int x, int y, int z) {
        return (!solid && getGrid().contains(x, y, z)) || !isSpaceSolid();
    }

    @Override
    public boolean moveTo(int x, int y, int z) {
        if (canMoveTo(x, y, z)) {
            return super.moveTo(x, y, z);
        }
        return false;
    }

    public boolean resetTo(Positional other) {
        return super.moveTo(other.getX(), other.getY(), other.getZ());
    }

    @Override
    public Space createSpace() {
        return super.createSpace();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionPointer that)) return false;
        if (!super.equals(o)) return false;
        return solid == that.solid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), solid);
    }
}
