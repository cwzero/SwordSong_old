package com.liquidforte.song.tilegrid;

import com.liquidforte.song.geometry.AbstractDelegatingGrid2D;
import com.liquidforte.song.tile.Tile;

public abstract class AbstractDelegatingTileGrid2D<G extends TileGrid2D<G, T>, T extends Tile> extends AbstractDelegatingGrid2D<G, T> implements TileGrid2D<G, T> {

}
