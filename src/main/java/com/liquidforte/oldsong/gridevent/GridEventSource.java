package com.liquidforte.oldsong.gridevent;

import com.liquidforte.oldsong.geometry.Point;

public interface GridEventSource<P extends Point, V> {
    <T extends GridListener<P, V>, L extends T> void addGridListener(Class<T> listenerClass, L listener);

    <T extends GridListener<P, V>, L extends T> void removeGridListener(Class<T> listenerClass, L listener);
}
