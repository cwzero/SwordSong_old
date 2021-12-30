package com.liquidforte.oldsong.tilegrid;

import com.liquidforte.oldsong.tile.Tile;
import com.liquidforte.oldsong.geometry.threed.AbstractDelegatingGrid3D;

public abstract class AbstractDelegatingTileGrid3D<G extends TileGrid3D<G, T>, T extends Tile> extends AbstractDelegatingGrid3D<G, T> implements TileGrid3D<G, T> {

}
