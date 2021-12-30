package com.liquidforte.song.tilegrid.basic;

import com.liquidforte.song.geometry.Array3DCreator;
import com.liquidforte.song.tile.Tile;

public interface BasicTileArrayCreator3D extends Array3DCreator<Tile> {
    BasicTileArrayCreator3D CREATOR = (w, h, d) -> new Tile[w][h][d];
}
