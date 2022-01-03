package com.liquidforte.song.block;

import com.liquidforte.song.tile.AbstractTile;
import com.liquidforte.song.util.Tileset;

import java.awt.*;

public class Blocks {
    public static final Block NORTH_WEST_CORNER = new Block(Tileset.LINE_0110, Color.white, true);
    public static final Block NORTH_EAST_CORNER = new Block(Tileset.LINE_0011, Color.white, true);
    public static final Block SOUTH_WEST_CORNER = new Block(Tileset.LINE_1100, Color.white, true);
    public static final Block SOUTH_EAST_CORNER = new Block(Tileset.LINE_1001, Color.white, true);

    public static final AbstractTile SMOOTH_FLOOR = new RoomBlock(Color.white, 0);
    public static final AbstractTile SPARSE_FLOOR = new RoomBlock(Color.white, 1);
    public static final AbstractTile MEDIUM_FLOOR = new RoomBlock(Color.white, 2);
    public static final AbstractTile DENSE_FLOOR = new RoomBlock(Color.white, 3);
}
