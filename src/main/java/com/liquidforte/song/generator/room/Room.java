package com.liquidforte.song.generator.room;

import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.two.Size2D;
import com.liquidforte.song.world.GameWorld;

import java.awt.*;

public class Room {
    private final Color color;
    private final RoomTiles tiles;
    private Size2D size;

    public Room(Color color, Size2D size) {
        this.color = color;
        this.size = size;
        this.tiles = new RoomTiles(color);
    }

    public void draw(GameWorld world, Point3D location) {
        int x = location.x();
        int y = location.y();
        int z = location.z();

        //drawCorners(world, x, y, z);
        //drawWalls(world, x, y, z);
        drawFloor(world, x, y, z);
    }

    protected void drawFloor(GameWorld world, int x, int y, int z) {
        for (int tx = 0; tx < size.width(); tx++) {
            for (int ty = 0; ty < size.height(); ty++) {
                world.setValue(x + tx, y + ty, z, tiles.getSparseFloor());
            }
        }
    }

    protected void drawCorners(GameWorld world, int x, int y, int z) {
        int west = x;
        int east = x + size.width() + 1;
        int north = y;
        int south = y + size.height() + 1;

        world.setValue(west, north, z, tiles.getNorthWestCorner());
        world.setValue(west, south, z, tiles.getSouthWestCorner());
        world.setValue(east, north, z, tiles.getNorthEastCorner());
        world.setValue(east, south, z, tiles.getSouthEastCorner());
    }

    protected void drawWalls(GameWorld world, int x, int y, int z) {
        int west = x;
        int east = x + size.width() + 1;
        int north = y;
        int south = y + size.height() + 1;

        for (int i = 1; i <= size.width(); i++) {
            world.setValue(x + i, north, z, tiles.getHorizontalWall());
            world.setValue(x + i, south, z, tiles.getHorizontalWall());
        }

        for (int i = 1; i <= size.height(); i++) {
            world.setValue(west, y + i, z, tiles.getVerticalWall());
            world.setValue(east, y + i, z, tiles.getVerticalWall());
        }
    }
}
