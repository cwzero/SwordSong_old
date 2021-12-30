package com.liquidforte.song.event;

import com.liquidforte.song.grid.TileGrid;

public class GridUpdateEvent {
    public final TileGrid grid;

    public GridUpdateEvent(TileGrid grid) {
        this.grid = grid;
    }

    public TileGrid getGrid() {
        return grid;
    }
}
