package com.liquidforte.song.drawing;

import com.liquidforte.song.block.RoomBlock;
import com.liquidforte.song.room.Room;
import com.liquidforte.song.space.SpaceGrid;
import com.liquidforte.song.tile.Direction;
import com.liquidforte.song.tile.FloorDecoration;
import com.liquidforte.song.tile.RoomTiles;

public class HallDrawing {
    private final SpaceGrid grid;
    private final RoomTiles roomTiles;

    public HallDrawing(SpaceGrid grid, RoomTiles roomTiles) {
        this.grid = grid;
        this.roomTiles = roomTiles;
    }

    public void drawHall(int x, int y, Direction direction) {
        switch (direction) {
            case North -> drawNorth(x, y);
            case East -> drawEast(x, y);
            case South -> drawSouth(x, y);
            case West -> drawWest(x, y);
            case Northeast -> drawNortheast(x, y);
            case Southeast -> drawSoutheast(x, y);
            case Southwest -> drawSouthwest(x, y);
            case Northwest -> drawNorthwest(x, y);
        }
    }

    public void drawVertical(int x, int y) {
        grid.setBackground(new RoomBlock(roomTiles, Direction.Full, FloorDecoration.Smooth), x, y);
        grid.setBackground(new RoomBlock(roomTiles, Direction.East, FloorDecoration.Smooth), x - 1, y);
        grid.setBackground(new RoomBlock(roomTiles, Direction.West, FloorDecoration.Smooth), x + 1, y);
    }

    public void drawHorizontal(int x, int y) {
        grid.setBackground(new RoomBlock(roomTiles, Direction.Full, FloorDecoration.Smooth), x, y);
        grid.setBackground(new RoomBlock(roomTiles, Direction.South, FloorDecoration.Smooth), x, y - 1);
        grid.setBackground(new RoomBlock(roomTiles, Direction.North, FloorDecoration.Smooth), x, y + 1);
    }

    public void drawNorth(int x, int y) {
        drawVertical(x, y);
    }

    public void drawEast(int x, int y) {
        drawHorizontal(x, y);
    }

    public void drawSouth(int x, int y) {
        drawVertical(x, y);
    }

    public void drawWest(int x, int y) {
        drawHorizontal(x, y);
    }

    public void drawNortheast(int x, int y) {

    }

    public void drawSoutheast(int x, int y) {

    }

    public void drawNorthwest(int x, int y) {

    }

    public void drawSouthwest(int x, int y) {

    }
}
