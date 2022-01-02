package com.liquidforte.song.block;

import com.liquidforte.song.util.Tileset;

import java.awt.*;

public class Blocks {
    public static final Block NORTH_WEST_CORNER = new Block(Tileset.LINE_0110, Color.white, true);
    public static final Block NORTH_EAST_CORNER = new Block(Tileset.LINE_0011, Color.white, true);
    public static final Block SOUTH_WEST_CORNER = new Block(Tileset.LINE_1100, Color.white, true);
    public static final Block SOUTH_EAST_CORNER = new Block(Tileset.LINE_1001, Color.white, true);

    public static final Block SMOOTH_FLOOR = new Block(Tileset.FULL_BLOCK, Color.white, false);
    public static final Block SPARSE_FLOOR = new Block(Tileset.SPARSE_DOTS, Color.white, false);
    public static final Block MEDIUM_FLOOR = new Block(Tileset.MEDIUM_DOTS, Color.white, false);
    public static final Block DENSE_FLOOR = new Block(Tileset.DENSE_DOTS, Color.white, false);
}
