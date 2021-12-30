package com.liquidforte.oldsong.tilegrid;

import com.liquidforte.oldsong.geometry.twod.AbstractDelegatingGrid2D;
import com.liquidforte.oldsong.tile.Tile;

public abstract class AbstractDelegatingTileGrid2D<G extends TileGrid2D<G, T>, T extends Tile> extends AbstractDelegatingGrid2D<G, T> implements TileGrid2D<G, T> {

}
