package com.liquidforte.song.gridevent;

import com.liquidforte.song.geometry.Point;

public interface GridEventSource<P extends Point, V> {
    <T extends GridListener<P, V>, L extends T> void addGridListener(Class<T> listenerClass, L listener);

    <T extends GridListener<P, V>, L extends T> void removeGridListener(Class<T> listenerClass, L listener);
}
