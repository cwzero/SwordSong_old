package com.liquidforte.song.gridevent.twod;

import com.liquidforte.song.geometry.Grid2D;
import com.liquidforte.song.gridevent.CancellableEvent;

public class Grid2DEvent<G extends Grid2D<G, V>, V> extends CancellableEvent {
    private final G grid;

    public Grid2DEvent(G grid) {
        this.grid = grid;
    }

    public G getGrid() {
        return grid;
    }
}
