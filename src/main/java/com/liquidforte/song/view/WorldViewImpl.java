package com.liquidforte.song.view;

import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.PointSet3D;
import com.liquidforte.song.math.geometry.two.PointSet2D;
import com.liquidforte.song.world.GameWorld;

public class WorldViewImpl extends AbstractGridView implements WorldView {
    private final GameWorld world;

    public WorldViewImpl(GameWorld world, PointSet2D space, PointSet3D viewTarget) {
        super(world, space, viewTarget);
        this.world = world;
    }

    public WorldViewImpl(GameWorld world, PointSet2D space) {
        this(world, space, Point3D.space);
    }

    @Override
    public GameWorld getWorld() {
        return world;
    }
}
