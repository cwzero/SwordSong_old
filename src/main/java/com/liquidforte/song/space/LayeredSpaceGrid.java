package com.liquidforte.song.space;

import com.liquidforte.song.world.LayeredGrid;

public class LayeredSpaceGrid extends LayeredGrid {
    public LayeredSpaceGrid(int width, int height, int depth) {
        super(width, height, depth, SpaceGrid::new);
    }

    public SpaceGrid getSpaceLayer(int z) {
        return (SpaceGrid) getLayer(z);
    }
}
