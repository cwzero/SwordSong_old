package com.liquidforte.song.block;

import com.liquidforte.song.tile.Direction;
import com.liquidforte.song.tile.FloorDecoration;
import com.liquidforte.song.tile.WallTiles;

public class RoomBlock extends Block {
    public RoomBlock(WallTiles tiles, Direction direction, FloorDecoration decoration) {
        super(tiles.getTile(direction, decoration), direction != Direction.Full);
    }
}
