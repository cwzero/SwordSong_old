package com.liquidforte.song.grid;

import com.liquidforte.song.grid.event.GridEventSource;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;
import com.liquidforte.song.math.geometry.Sized;
import com.liquidforte.song.pointer.Destination;
import com.liquidforte.song.pointer.DestinationPointer;
import com.liquidforte.song.pointer.Source;
import com.liquidforte.song.pointer.SourcePointer;

import java.util.Map;
import java.util.Set;

public interface Grid<P extends Point<P>, S extends Size<P, S>, V> extends Map<P, V>, Source<P, V>, Destination<P, V>, GridEventSource<P, S, V>, Sized<P, S> {
    interface GridEntrySet<P, V> extends Set<Map.Entry<P, V>> {

    }

    interface GridEntry<P, V> extends Map.Entry<P, V>, SourcePointer<P, V>, DestinationPointer<P, V> {

    }
}
