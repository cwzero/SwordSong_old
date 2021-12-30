package com.liquidforte.oldsong.tilegrid.basic;

import com.liquidforte.oldsong.geometry.twod.Array2DCreator;
import com.liquidforte.oldsong.tile.Tile;

public interface BasicTileArrayCreator2D extends Array2DCreator<Tile> {
    BasicTileArrayCreator2D CREATOR = (w, h) -> new Tile[w][h];
}
