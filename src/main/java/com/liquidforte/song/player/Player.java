package com.liquidforte.song.player;

import com.liquidforte.song.entity.MovableEntity;
import com.liquidforte.song.space.LayeredSpaceGrid;
import com.liquidforte.song.tile.ColoredTile;

public class Player extends MovableEntity {
    private final ColoredTile tile;

    public Player(LayeredSpaceGrid world, ColoredTile tile) {
        super(world, tile, true);
        this.tile = tile;
    }
}
