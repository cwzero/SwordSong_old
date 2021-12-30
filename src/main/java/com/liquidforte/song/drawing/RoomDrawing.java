package com.liquidforte.song.drawing;

import com.liquidforte.song.block.Block;
import com.liquidforte.song.block.RoomBlock;
import com.liquidforte.song.space.SpaceGrid;
import com.liquidforte.song.tile.Direction;
import com.liquidforte.song.tile.FloorDecoration;
import com.liquidforte.song.tile.RoomTiles;

public class RoomDrawing {
    private final SpaceGrid grid;
    private final RoomTiles roomTiles;
    private final FloorDecorationStrategy decorationStrategy;

    public RoomDrawing(SpaceGrid grid, RoomTiles roomTiles, FloorDecorationStrategy decorationStrategy) {
        this.roomTiles = roomTiles;
        this.grid = grid;
        this.decorationStrategy = decorationStrategy;
    }

    public void drawRoom(int x, int y, int w, int h) {
        for (int tx = 0; tx <= w; tx++) {
            for (int ty = 0; ty <= h; ty++) {
                setBlock(x, y, w, h, tx, ty);
            }
        }
    }

    public void setBlock(int x, int y, int w, int h, int tx, int ty) {
        Direction direction = getDirection(w, h, tx, ty);
        FloorDecoration decoration = decorationStrategy.getDecoration(w, h, tx, ty, direction);
        Block block = new RoomBlock(roomTiles, direction, decoration);
        grid.setBackground(block,x + tx, y + ty);
    }

    public static Direction getDirection(int w, int h, int tx, int ty) {
        boolean north = ty == h;
        boolean east = tx == 0;
        boolean south = ty == 0;
        boolean west = tx == w;

        return Direction.getDirection(north, east, south, west);
    }
}
