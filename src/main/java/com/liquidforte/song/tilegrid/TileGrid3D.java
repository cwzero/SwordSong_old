package com.liquidforte.song.tilegrid;

import com.liquidforte.song.geometry.Grid3D;
import com.liquidforte.song.tile.Tile;

public interface TileGrid3D<G extends TileGrid3D<G, T>, T extends Tile> extends Grid3D<G, T> {

}
