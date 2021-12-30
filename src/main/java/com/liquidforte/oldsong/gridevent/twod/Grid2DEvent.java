package com.liquidforte.oldsong.gridevent.twod;

import com.liquidforte.oldsong.gridevent.CancellableEvent;
import com.liquidforte.oldsong.geometry.twod.Grid2D;

public class Grid2DEvent<G extends Grid2D<G, V>, V> extends CancellableEvent {
    private final G grid;

    public Grid2DEvent(G grid) {
        this.grid = grid;
    }

    public G getGrid() {
        return grid;
    }
}
