package com.liquidforte.oldsong.tilegrid;

import com.liquidforte.oldsong.tile.Tile;
import com.liquidforte.oldsong.geometry.threed.Grid3D;

public interface TileGrid3D<G extends TileGrid3D<G, T>, T extends Tile> extends Grid3D<G, T> {

}
