package com.liquidforte.oldsong.geometry;

import com.liquidforte.oldsong.gridevent.GridEventSource;

import java.util.Map;

public interface Grid<P extends Point, V> extends Map<P, V>, Dest<P, V>, GridEventSource<P, V> {

}
