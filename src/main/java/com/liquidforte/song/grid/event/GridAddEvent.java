package com.liquidforte.song.grid.event;

import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public interface GridAddEvent<P extends Point<P>, S extends Size<P, S>, V> extends GridPointEvent<P, S, V> {
    V getAdded();
}
