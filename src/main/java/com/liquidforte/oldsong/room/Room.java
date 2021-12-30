package com.liquidforte.oldsong.room;

import com.liquidforte.oldsong.block.RoomBlock;
import com.liquidforte.oldsong.space.SpaceGrid;
import com.liquidforte.oldsong.tile.Direction;
import com.liquidforte.oldsong.tile.FloorDecoration;
import com.liquidforte.oldsong.tile.RoomTiles;

import java.awt.*;

public class Room extends SpaceGrid {
    private RoomTiles tiles;

    public Room(RoomTiles tiles, Dimension size) {
        this(tiles, size.width, size.height);
    }

    public Room(RoomTiles tiles, int width, int height) {
        super(width, height);
        this.tiles = tiles;
        drawRoom();
    }

    public void setTiles(RoomTiles tiles) {
        this.tiles = tiles;
        drawRoom();
        fireUpdate();
    }

    public void addToWorld(SpaceGrid world, int worldX, int worldY) {
        draw(world, worldX, worldY);
        addListener(event -> draw(world, worldX, worldY));
    }

    private void drawRoom() {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                drawTile(x, y);
            }
        }
    }

    private void drawTile(int x, int y) {
        Direction direction = getDirection(x, y);
        setBackground(new RoomBlock(tiles, direction, FloorDecoration.Smooth), x, y);
    }

    public Direction getDirection(int x, int y) {
        boolean north = y == (getHeight() - 1);
        boolean east = x == 0;
        boolean south = y == 0;
        boolean west = x == (getWidth() - 1);

        return Direction.getDirection(north, east, south, west);
    }
}
