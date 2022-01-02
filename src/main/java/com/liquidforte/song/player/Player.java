package com.liquidforte.song.player;

import com.liquidforte.song.tile.AbstractTile;
import com.liquidforte.song.tile.StackTile;
import com.liquidforte.song.util.TextureUtil;
import com.liquidforte.song.world.GameWorld;
import com.liquidforte.song.world.GameWorldLayer;

import java.awt.*;

public class Player extends AbstractTile {
    private GameWorld world;
    private int x, y, z;

    public Player() {
        super(TextureUtil.getTexture(Color.blue, '@'));
    }

    public void setWorld(GameWorld world) {
        this.world = world;
    }

    protected StackTile getTile() {
        return world.create(x, y, z);
    }

    protected StackTile getTile(int x, int y, int z) {
        return world.create(x, y, z);
    }

    public GameWorldLayer getLayer() {
        return world.getLayer(z);
    }

    public boolean canMove(int x, int y, int z) {
        return getTile(x, y, z) != null && !getTile(x, y, z).isSolid();
    }

    public void place(int x, int y, int z) {
        if (canMove(x, y, z)) {
            remove();
            getTile(x, y, z).setTile(this);
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public void remove() {
        if (getTile() != null && getTile().getTile() != null && getTile().getTile().equals(this)) {
            getTile().setTile(null);
        }
    }

    public void moveTo(int dx, int dy, int dz) {
        place(x + dx, y + dy, z + dz);
    }

    public void moveWest() {
        moveTo(-1, 0, 0);
    }

    public void moveEast() {
        moveTo(1, 0, 0);
    }

    public void moveNorth() {
        moveTo(0, -1, 0);
    }

    public void moveSouth() {
        moveTo(0, 1, 0);
    }

    public void moveUp() {
        moveTo(0, 0, -1);
    }

    public void moveDown() {
        moveTo(0, 0, 1);
    }
}
