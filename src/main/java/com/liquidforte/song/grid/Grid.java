package com.liquidforte.song.grid;

import com.liquidforte.song.grid.event.GridEventSource;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;
import com.liquidforte.song.pointer.Destination;
import com.liquidforte.song.pointer.Source;

import java.util.Map;

public interface Grid<P extends Point, S extends Size<P>, V> extends Map<P, V>, Source<P, V>, Destination<P, V>, GridEventSource<P, V> {
    S getSize();
}
