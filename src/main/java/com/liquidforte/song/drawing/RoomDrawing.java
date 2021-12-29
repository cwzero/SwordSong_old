package com.liquidforte.song.drawing;

import com.liquidforte.song.block.Block;
import com.liquidforte.song.block.RoomBlock;
import com.liquidforte.song.space.SpaceGrid;
import com.liquidforte.song.tile.Direction;
import com.liquidforte.song.tile.FloorDecoration;
import com.liquidforte.song.tile.WallTiles;

public class RoomDrawing {
    private final WallTiles wallTiles;

    public RoomDrawing(WallTiles wallTiles) {
        this.wallTiles = wallTiles;
    }

    public void drawRoom(SpaceGrid grid, FloorDecorationStrategy floorDecorationStrategy, int x, int y, int w, int h) {
        for (int tx = 0; tx <= w; tx++) {
            for (int ty = 0; ty <= h; ty++) {
                setBlock(grid, floorDecorationStrategy, x, y, w, h, tx, ty);
            }
        }
    }

    public void setBlock(SpaceGrid grid, FloorDecorationStrategy floorDecorationStrategy, int x, int y, int w, int h, int tx, int ty) {
        Direction direction = getDirection(grid, w, h, tx, ty);
        FloorDecoration decoration = floorDecorationStrategy.getDecoration(w, h, tx, ty, direction);
        Block block = new RoomBlock(wallTiles, direction, decoration);
        grid.createSpace(x + tx, y + ty).setBackground(block);
    }

    public static Direction getDirection(SpaceGrid grid, int w, int h, int tx, int ty) {
        boolean north = ty == h;
        boolean east = tx == 0;
        boolean south = ty == 0;
        boolean west = tx == w;

        return Direction.getDirection(north, east, south, west);
    }
}
