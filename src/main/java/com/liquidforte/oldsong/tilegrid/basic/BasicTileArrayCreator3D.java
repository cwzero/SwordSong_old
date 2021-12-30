package com.liquidforte.oldsong.tilegrid.basic;

import com.liquidforte.oldsong.geometry.threed.Array3DCreator;
import com.liquidforte.oldsong.tile.Tile;

public interface BasicTileArrayCreator3D extends Array3DCreator<Tile> {
    BasicTileArrayCreator3D CREATOR = (w, h, d) -> new Tile[w][h][d];
}
