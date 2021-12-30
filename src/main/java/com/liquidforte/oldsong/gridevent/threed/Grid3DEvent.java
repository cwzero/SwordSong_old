package com.liquidforte.oldsong.gridevent.threed;

import com.liquidforte.oldsong.gridevent.CancellableEvent;
import com.liquidforte.oldsong.geometry.threed.Grid3D;

public class Grid3DEvent<G extends Grid3D<G, V>, V> extends CancellableEvent {
    private final G grid;

    public Grid3DEvent(G grid) {
        this.grid = grid;
    }

    public G getGrid() {
        return grid;
    }
}
