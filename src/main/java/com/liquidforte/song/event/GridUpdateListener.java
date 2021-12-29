package com.liquidforte.song.event;

import java.util.EventListener;

@FunctionalInterface
public interface GridUpdateListener extends EventListener {
    void gridUpdate(GridUpdateEvent event);

    default boolean filter(GridUpdateEvent event) {
        return true;
    }
}
