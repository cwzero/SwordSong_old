package com.liquidforte.song.player;

import com.liquidforte.song.block.RoomBlock;
import com.liquidforte.song.entity.MovableBlock;
import com.liquidforte.song.space.LayeredSpaceGrid;
import com.liquidforte.song.tile.ColoredTile;
import com.liquidforte.song.tile.FloorDecoration;

public class Player extends MovableBlock {
    public Player(LayeredSpaceGrid world, ColoredTile tile) {
        super(world, tile, true);
    }

    public void smooth() {
        RoomBlock roomBlock = (RoomBlock) (getSpace().getBackground());
        roomBlock.setDecoration(FloorDecoration.Smooth);
    }
}
