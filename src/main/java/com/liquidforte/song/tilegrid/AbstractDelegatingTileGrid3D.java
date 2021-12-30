package com.liquidforte.song.tilegrid;

import com.liquidforte.song.geometry.threed.AbstractDelegatingGrid3D;
import com.liquidforte.song.tile.Tile;

public abstract class AbstractDelegatingTileGrid3D<G extends TileGrid3D<G, T>, T extends Tile> extends AbstractDelegatingGrid3D<G, T> implements TileGrid3D<G, T> {

}
