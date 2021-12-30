package com.liquidforte.oldsong.gridevent.threed;

import com.liquidforte.oldsong.geometry.threed.Grid3D;

public interface Grid3DEventSource<G extends Grid3D<G, V>, V> {
    <T extends Grid3DListener<G, V>, L extends T> void addGridListener(Class<T> listenerClass, L listener);

    <T extends Grid3DListener<G, V>, L extends T> void removeGridListener(Class<T> listenerClass, L listener);
}
