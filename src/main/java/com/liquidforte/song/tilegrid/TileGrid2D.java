package com.liquidforte.song.tilegrid;

import com.liquidforte.song.geometry.twod.Grid2D;
import com.liquidforte.song.tile.Tile;

public interface TileGrid2D<G extends TileGrid2D<G, T>, T extends Tile> extends Grid2D<G, T> {

}
