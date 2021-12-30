package com.liquidforte.song.grid.event;

import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public interface GridAddEvent<P extends Point, S extends Size<P>, V> extends GridPointEvent<P, S, V> {
    V getAdded();
}
