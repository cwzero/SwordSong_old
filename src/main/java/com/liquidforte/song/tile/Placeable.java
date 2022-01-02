package com.liquidforte.song.tile;

import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.world.GameWorld;

public interface Placeable extends Tile {
    boolean place(GameWorld world, Point3D pos);
}
