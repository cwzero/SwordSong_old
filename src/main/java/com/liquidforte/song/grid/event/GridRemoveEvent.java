package com.liquidforte.song.grid.event;

import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public interface GridRemoveEvent<P extends Point, S extends Size<P>, V> extends GridPointEvent<P, S, V> {
    V getRemoved();
}