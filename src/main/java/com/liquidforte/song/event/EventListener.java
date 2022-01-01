package com.liquidforte.song.event;

public interface EventListener extends java.util.EventListener {
    default Class<?> getEventClass() {
        return Object.class;
    }

    default boolean filterEvent(Object event) {
        return getEventClass().isInstance(event);
    }

    void handleEvent(Object event);
}
