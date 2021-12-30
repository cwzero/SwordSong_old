package com.liquidforte.oldsong.gridevent.twod;

import com.liquidforte.oldsong.geometry.twod.Grid2D;

public interface Grid2DEventSource<G extends Grid2D<G, V>, V> {
    <T extends Grid2DListener<G, V>, L extends T> void addGridListener(Class<T> listenerClass, L listener);

    <T extends Grid2DListener<G, V>, L extends T> void removeGridListener(Class<T> listenerClass, L listener);
}
