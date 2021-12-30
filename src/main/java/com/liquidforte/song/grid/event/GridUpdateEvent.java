package com.liquidforte.song.grid.event;

import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

public interface GridUpdateEvent<P extends Point, S extends Size<P>, V> extends GridAddEvent<P, S, V>, GridRemoveEvent<P, S, V> {

}
