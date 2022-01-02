package com.liquidforte.song.view;

import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.tilegrid.two.TileGrid2D;

public interface GridView extends TileGrid2D {
    void moveTo(Point3D target);
}
