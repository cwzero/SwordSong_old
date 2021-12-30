package com.liquidforte.song.geometry;

import com.liquidforte.song.gridevent.GridEventSource;

import java.util.Map;

public interface Grid<P extends Point, V> extends Map<P, V>, Dest<P, V>, GridEventSource<P, V> {

}
