package com.liquidforte.oldsong.tilegrid;

import com.liquidforte.oldsong.tile.Tile;
import com.liquidforte.oldsong.geometry.twod.Grid2D;

public interface TileGrid2D<G extends TileGrid2D<G, T>, T extends Tile> extends Grid2D<G, T> {

}
