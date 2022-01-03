package com.liquidforte.song.block;

import com.liquidforte.song.tile.AbstractTile;
import com.liquidforte.song.util.Tileset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RoomBlock extends AbstractTile {
    public final Block smoothFloor;
    public final Block sparseFloor;
    public final Block mediumFloor;
    public final Block denseFloor;

    private final int type;

    public RoomBlock(Color color, int type) {
        smoothFloor = new Block(Tileset.FULL_BLOCK, color, false);
        sparseFloor = new Block(Tileset.SPARSE_DOTS, color, false);
        mediumFloor = new Block(Tileset.MEDIUM_DOTS, color, false);
        denseFloor = new Block(Tileset.DENSE_DOTS, color, false);

        this.type = type;
    }

    public Block smooth() {
        return smoothFloor;
    }

    public Block getBlock() {
        return switch (type) {
            case 1 -> sparseFloor;
            case 2 -> mediumFloor;
            case 3 -> denseFloor;
            default -> smoothFloor;
        };
    }

    @Override
    public BufferedImage getTexture() {
        return getBlock().getTexture();
    }

    @Override
    public boolean isSolid() {
        return getBlock().isSolid();
    }
}
