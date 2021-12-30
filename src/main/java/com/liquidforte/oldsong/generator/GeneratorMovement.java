package com.liquidforte.oldsong.generator;

import com.liquidforte.oldsong.space.LayeredSpaceGrid;
import com.liquidforte.oldsong.space.Space;
import com.liquidforte.oldsong.entity.AbstractMovement;

public class GeneratorMovement extends AbstractMovement {
    public GeneratorMovement(LayeredSpaceGrid world) {
        super(world);
    }

    @Override
    public boolean isSourceValid(Space source) {
        return true;
    }

    @Override
    public boolean isDestValid(Space dest) {
        return true;
    }

    @Override
    public boolean remove(Space source) {
        return true;
    }

    @Override
    public boolean place(Space dest) {
        return true;
    }
}
