package com.liquidforte.song.generator.room;

import com.liquidforte.song.tile.*;

import java.awt.*;

public class WallTiles {
    private static final CharTile NORTH_WEST_CORNER = new BasicCharTile(Tileset.LINE_0110);
    private static final CharTile NORTH_EAST_CORNER = new BasicCharTile(Tileset.LINE_0011);
    private static final CharTile SOUTH_WEST_CORNER = new BasicCharTile(Tileset.LINE_1100);
    private static final CharTile SOUTH_EAST_CORNER = new BasicCharTile(Tileset.LINE_1001);
    private static final CharTile HORIZONTAL_WALL = new BasicCharTile(Tileset.LINE_0101);
    private static final CharTile VERTICAL_WALL = new BasicCharTile(Tileset.LINE_1010);

    private final Tile northWestCorner;
    private final Tile northEastCorner;
    private final Tile southWestCorner;
    private final Tile southEastCorner;
    private final Tile horizontalWall;
    private final Tile verticalWall;

    protected final Color color;

    public WallTiles(Color color) {
        this.color = color;

        this.northWestCorner = new BasicColoredTile(NORTH_WEST_CORNER, color);
        this.northEastCorner = new BasicColoredTile(NORTH_EAST_CORNER, color);
        this.southWestCorner = new BasicColoredTile(SOUTH_WEST_CORNER, color);
        this.southEastCorner = new BasicColoredTile(SOUTH_EAST_CORNER, color);

        this.horizontalWall = new BasicColoredTile(HORIZONTAL_WALL, color);
        this.verticalWall = new BasicColoredTile(VERTICAL_WALL, color);
    }

    public Color getColor() {
        return color;
    }

    public Tile getNorthWestCorner() {
        return StackTile.foreground(northWestCorner);
    }

    public Tile getNorthEastCorner() {
        return StackTile.foreground(northEastCorner);
    }

    public Tile getSouthWestCorner() {
        return StackTile.foreground(southWestCorner);
    }

    public Tile getSouthEastCorner() {
        return StackTile.foreground(southEastCorner);
    }

    public Tile getHorizontalWall() {
        return StackTile.foreground(horizontalWall);
    }

    public Tile getVerticalWall() {
        return StackTile.foreground(verticalWall);
    }
}
