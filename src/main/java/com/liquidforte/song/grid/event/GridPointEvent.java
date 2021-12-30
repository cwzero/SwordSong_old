package com.liquidforte.song.grid.event;

import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public interface GridPointEvent<P extends Point<P>, S extends Size<P, S>, V> extends GridEvent<P, S, V> {
    P getPoint();
}
