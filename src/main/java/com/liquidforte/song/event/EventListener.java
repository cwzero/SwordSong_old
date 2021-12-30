package com.liquidforte.song.event;

public interface EventListener extends java.util.EventListener {
    void handleEvent(Event event);

    default boolean filterEvent(Event event) {
        return true;
    }
}
