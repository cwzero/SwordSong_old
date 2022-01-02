package com.liquidforte.song.generator.room;

import com.liquidforte.song.tile.*;

import java.awt.*;

public class RoomTiles extends WallTiles {
    private static final CharTile SMOOTH_FLOOR = new BasicCharTile(Tileset.FULL_BLOCK);
    private static final CharTile SPARSE_FLOOR = new BasicCharTile(Tileset.SPARSE_DOTS);
    private static final CharTile MEDIUM_FLOOR = new BasicCharTile(Tileset.MEDIUM_DOTS);
    private static final CharTile DENSE_FLOOR = new BasicCharTile(Tileset.DENSE_DOTS);

    private final Tile smoothFloor;
    private final Tile sparseFloor;
    private final Tile mediumFloor;
    private final Tile denseFloor;

    public RoomTiles(Color color) {
        super(color);
        smoothFloor = new BasicColoredTile(SMOOTH_FLOOR, color);
        sparseFloor = new BasicColoredTile(SPARSE_FLOOR, color);
        mediumFloor = new BasicColoredTile(MEDIUM_FLOOR, color);
        denseFloor = new BasicColoredTile(DENSE_FLOOR, color);
    }

    public Tile getSmoothFloor() {
        return StackTile.background(smoothFloor);
    }

    public Tile getSparseFloor() {
        return StackTile.background(sparseFloor);
    }

    public Tile getMediumFloor() {
        return StackTile.background(mediumFloor);
    }

    public Tile getDenseFloor() {
        return StackTile.background(denseFloor);
    }
}
