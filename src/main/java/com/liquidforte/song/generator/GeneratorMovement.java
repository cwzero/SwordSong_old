package com.liquidforte.song.generator;

import com.liquidforte.song.entity.AbstractMovement;
import com.liquidforte.song.space.LayeredSpaceGrid;
import com.liquidforte.song.space.Space;

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
