package com.liquidforte.song.tile;

import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.world.GameWorld;

public abstract class AbstractSingleton extends AbstractPlaceable implements Block {
    private final boolean solid;
    private boolean placed;
    private boolean check;

    public AbstractSingleton(Tile tile) {
        super(tile);
        this.placed = false;
        this.check = true;
        this.solid = true;
    }

    public AbstractSingleton(Tile tile, boolean solid) {
        super(tile);
        this.placed = false;
        this.check = true;
        this.solid = solid;
    }

    public boolean isSolid() {
        return solid;
    }

    public boolean isPlaced(GameWorld world) {
        if (check) {
            check(world);
        }
        return placed;
    }

    protected boolean check(GameWorld world) {
        check = false;
        Tile currentTile = world.getValue(getPos());
        if (currentTile == null) {
            return false;
        } else {
            if (currentTile.equals(this)) {
                return true;
            } else if (currentTile instanceof StackTile s) {
                return s.getForeground() != null && s.getForeground().equals(this);
            }
        }
        return false;
    }

    protected synchronized boolean remove(GameWorld world) {
        Tile currentTile = world.getValue(getPos());

        if (currentTile == null) {
            placed = false;
            return false;
        } else if (currentTile instanceof StackTile s) {
            Tile foreground = s.getForeground();
            if (foreground != null && foreground.equals(this)) {
                s.setForeground(null);
                placed = false;
                if (s.isEmpty()) {
                    world.setValue(this.pos, null);
                }
                world.setValue(pos, s);
                return true;
            }
        } else if (currentTile.equals(this)) {
            world.setValue(this.pos, null);
            placed = false;
            return true;
        }
        return false;
    }

    protected boolean canPlace(GameWorld world, Point3D target) {
        if (world.construct(target) == null) {
            return false;
        }

        if (!isSolid()) {
            return true;
        }

        Tile newTile = world.getValue(target);

        if (newTile instanceof StackTile s) {
            return !s.isSolid() && s.getForeground() == null;
        }

        return newTile != null && !newTile.isSolid();
    }

    protected synchronized boolean doPlace(GameWorld world, Point3D pos) {
        Tile newTile = world.getValue(pos);
        if (newTile == null) {
            world.setValue(pos, this);
            this.pos = pos;
            return true;
        } else {
            if (newTile instanceof StackTile s) {
                if (s.getForeground() == null) {
                    s.setForeground(this);
                    this.pos = pos;
                    world.setValue(pos, s);
                    return true;
                }
            } else {
                StackTile stack = StackTile.background(newTile);
                stack.setForeground(this);
                world.setValue(pos, stack);
                this.pos = pos;
                return true;
            }
        }
        return false;
    }

    @Override
    public synchronized boolean place(GameWorld world, Point3D pos) {
        if (canPlace(world, pos)) {
            if (check) {
                placed = check(world);
            }

            if (placed) {
                if (remove(world)) {
                    placed = doPlace(world, pos);
                    return placed;
                }
            } else {
                placed = doPlace(world, pos);
                return placed;
            }
        }
        return false;
    }
}
