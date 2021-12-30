package com.liquidforte.oldsong.event;

import java.util.EventListener;

@FunctionalInterface
public interface MovementListener extends EventListener {
    void handleMove(MovementEvent event);

    default boolean filterMove(MovementEvent event) {
        return true;
    }
}
