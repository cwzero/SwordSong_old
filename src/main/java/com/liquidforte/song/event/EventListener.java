package com.liquidforte.song.event;

public interface EventListener extends java.util.EventListener {
    default boolean filterEvent(Object event) {
        return true;
    }
}
