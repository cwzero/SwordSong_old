package com.liquidforte.oldsong.space;

import com.liquidforte.oldsong.world.LayeredGrid;

public class LayeredSpaceGrid extends LayeredGrid {
    public LayeredSpaceGrid(int width, int height, int depth) {
        super(width, height, depth, SpaceGrid::new);
    }

    public SpaceGrid getSpaceLayer(int z) {
        return (SpaceGrid) getLayer(z);
    }

    public Space getSpace(int x, int y, int z) {
        if (contains(x, y, z)) {
            return getSpaceLayer(z).getSpace(x, y);
        }
        return null;
    }

    public Space createSpace(int x, int y, int z) {
        if (contains(x, y, z)) {
            return getSpaceLayer(z).createSpace(x, y);
        }
        return null;
    }

    public boolean contains(int x, int y, int z) {
        return z >= 0 && z < getDepth() && getSpaceLayer(z).contains(x, y);
    }
}
