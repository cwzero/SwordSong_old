package com.liquidforte.oldsong.event;

import com.liquidforte.oldsong.grid.TileGrid;

public class GridUpdateEvent {
    public final TileGrid grid;

    public GridUpdateEvent(TileGrid grid) {
        this.grid = grid;
    }

    public TileGrid getGrid() {
        return grid;
    }
}
