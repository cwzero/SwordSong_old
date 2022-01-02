package com.liquidforte.song.tile;

import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.world.GameWorld;

import java.awt.image.BufferedImage;

public abstract class AbstractPlaceable implements Placeable {
    protected Tile tile;
    protected Point3D pos;

    public AbstractPlaceable(Tile tile) {
        this(tile, new Point3D(0, 0, 0));
    }


    public AbstractPlaceable(Tile tile, Point3D pos) {
        this.tile = tile;
        this.pos = pos;
    }

    @Override
    public BufferedImage getTexture() {
        return tile.getTexture();
    }

    @Override
    public boolean place(GameWorld world, Point3D pos) {
        world.setValue(pos, this);
        return true;
    }

    public Point3D getPos() {
        return pos;
    }
}
