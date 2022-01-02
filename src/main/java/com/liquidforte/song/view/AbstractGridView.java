package com.liquidforte.song.view;

import com.liquidforte.song.grid.event.GridEvent2D;
import com.liquidforte.song.grid.event.GridEvent3D;
import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.PointSet3D;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.PointSet2D;
import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.tilegrid.three.TileGrid3D;
import com.liquidforte.song.tilegrid.two.AbstractTileGrid2D;

public abstract class AbstractGridView extends AbstractTileGrid2D implements GridView {
    private TileGrid3D source;
    private PointSet3D viewTarget;

    public AbstractGridView(TileGrid3D source, PointSet2D space, PointSet3D viewTarget) {
        super(space);
        this.viewTarget = viewTarget;
        this.source = source;

        getSource().addListener(event -> {
            if (event instanceof GridEvent3D e) {
                Point3D location = getViewTarget().construct(e.getLocation());
                if (location.z() == 0) {
                    Point2D viewLocation = construct(new Point2D(location.x(), location.y()));
                    fireEvent(new GridEvent2D<>(this, viewLocation, (Tile) e.getOldValue(), (Tile) e.getNewValue()));
                }
            }
        });
    }

    public AbstractGridView(TileGrid3D source, PointSet2D space) {
        this(source, space, Point3D.space);
    }

    @Override
    protected Tile doSetValue(Point2D p, Tile tile) {
        Point2D target = construct(p);
        Point3D sTarget = getViewTarget().construct(target.x(), target.y(), 0);
        return getSource().setValue(sTarget, tile);
    }

    @Override
    protected Tile doGetValue(Point2D target) {
        if (target == null) return null;
        Point3D sTarget = getViewTarget().construct(target.x(), target.y(), 0);
        if (sTarget == null) return null;
        return getSource().getValue(sTarget);
    }

    protected TileGrid3D getSource() {
        return source;
    }

    protected void setSource(TileGrid3D source) {
        this.source = source;
    }

    protected PointSet3D getViewTarget() {
        return viewTarget;
    }

    protected void setViewTarget(PointSet3D viewTarget) {
        this.viewTarget = viewTarget;
    }

    @Override
    public void moveTo(Point3D target) {
        setViewTarget(Point3D.space.map(target));
    }
}
