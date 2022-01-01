package com.liquidforte.song.math.geometry;

public interface Spatial<P extends Point> extends PointSet<P> {
    Spatial<P> translate(Offset<P> offset);

    Spatial<P> scale(Constrain<P> constrain);
}
