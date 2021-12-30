package com.liquidforte.song.entity;

import com.liquidforte.song.block.Block;
import com.liquidforte.song.space.LayeredSpaceGrid;
import com.liquidforte.song.space.Space;
import com.liquidforte.song.tile.Tile;

public class MovableBlock extends Block implements Movable {
    private final TileMovement movement;

    public MovableBlock(LayeredSpaceGrid world, Tile tile, boolean solid) {
        super(tile, solid);
        this.movement = new TileMovement(world, this);
    }

    @Override
    public boolean moveTo(int x, int y, int z) {
        return movement.getDest().moveTo(x, y, z) && movement.move();
    }

    @Override
    public int getX() {
        return movement.getSource().getX();
    }

    @Override
    public int getY() {
        return movement.getSource().getY();
    }

    @Override
    public int getZ() {
        return movement.getSource().getZ();
    }

    @Override
    public Space getSpace() {
        return movement.getSourceSpace();
    }
}
