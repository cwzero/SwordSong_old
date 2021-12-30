package com.liquidforte.oldsong.event;

import java.util.EventListener;

@FunctionalInterface
public interface GeneratorListener extends EventListener {
    void handle(GeneratorEvent event);

    default boolean filter(GeneratorEvent event) {
        return true;
    }
}
