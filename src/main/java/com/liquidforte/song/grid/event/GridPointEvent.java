package com.liquidforte.song.grid.event;

import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public interface GridPointEvent<P extends Point, S extends Size<P>, V> extends GridEvent<P, S, V> {
    P getPoint();
}
