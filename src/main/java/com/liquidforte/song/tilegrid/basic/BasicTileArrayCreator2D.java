package com.liquidforte.song.tilegrid.basic;

import com.liquidforte.song.geometry.twod.Array2DCreator;
import com.liquidforte.song.tile.Tile;

public interface BasicTileArrayCreator2D extends Array2DCreator<Tile> {
    BasicTileArrayCreator2D CREATOR = (w, h) -> new Tile[w][h];
}
