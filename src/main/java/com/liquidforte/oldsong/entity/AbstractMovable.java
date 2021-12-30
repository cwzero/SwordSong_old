package com.liquidforte.oldsong.entity;

import com.liquidforte.oldsong.space.LayeredSpaceGrid;

public abstract class AbstractMovable extends AbstractPositional implements Movable {
    public AbstractMovable(LayeredSpaceGrid grid) {
        super(grid);
    }

    @Override
    public boolean moveTo(int x, int y, int z) {
        setPosition(x, y, z);
        return true;
    }
}
