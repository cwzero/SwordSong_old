package com.liquidforte.song.block;

import com.liquidforte.song.tile.Direction;
import com.liquidforte.song.tile.FloorDecoration;
import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.tile.RoomTiles;

public class RoomBlock extends Block {
    private RoomTiles tiles;
    private Direction direction;
    private FloorDecoration decoration;

    public RoomBlock(RoomTiles tiles, Direction direction, FloorDecoration decoration) {
        super(direction != Direction.Full);
        this.tiles = tiles;
        this.direction = direction;
        this.decoration = decoration;
    }

    public RoomBlock smooth() {
        return new RoomBlock(tiles, direction, FloorDecoration.Smooth);
    }

    public RoomTiles getTiles() {
        return tiles;
    }

    public Direction getDirection() {
        return direction;
    }

    public FloorDecoration getDecoration() {
        return decoration;
    }

    public void setTiles(RoomTiles tiles) {
        this.tiles = tiles;
        fireUpdate();
    }

    public void setDecoration(FloorDecoration decoration) {
        this.decoration = decoration;
        fireUpdate();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        fireUpdate();
    }

    @Override
    public Tile getTile() {
        return tiles.getTile(direction, decoration);
    }
}
