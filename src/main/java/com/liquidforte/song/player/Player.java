package com.liquidforte.song.player;

import com.liquidforte.song.tile.AbstractSingleton;
import com.liquidforte.song.tile.BasicColoredTile;
import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.tile.Tileset;

import java.awt.*;

public class Player extends AbstractSingleton {
    public Player() {
        this(new BasicColoredTile(Tileset.AT, Color.white));
    }

    public Player(Tile tile) {
        super(tile);
    }
}
