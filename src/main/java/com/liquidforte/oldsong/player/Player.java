package com.liquidforte.oldsong.player;

import com.liquidforte.oldsong.block.RoomBlock;
import com.liquidforte.oldsong.entity.MovableBlock;
import com.liquidforte.oldsong.space.LayeredSpaceGrid;
import com.liquidforte.oldsong.tile.ColoredTile;
import com.liquidforte.oldsong.tile.FloorDecoration;

public class Player extends MovableBlock {
    public Player(LayeredSpaceGrid world, ColoredTile tile) {
        super(world, tile, true);
    }

    public void smooth() {
        RoomBlock roomBlock = (RoomBlock) (getSpace().getBackground());
        roomBlock.setDecoration(FloorDecoration.Smooth);
    }
}
