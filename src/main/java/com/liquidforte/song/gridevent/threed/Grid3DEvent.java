package com.liquidforte.song.gridevent.threed;

import com.liquidforte.song.geometry.Grid3D;
import com.liquidforte.song.gridevent.CancellableEvent;

public class Grid3DEvent<G extends Grid3D<G, V>, V> extends CancellableEvent {
    private final G grid;

    public Grid3DEvent(G grid) {
        this.grid = grid;
    }

    public G getGrid() {
        return grid;
    }
}
