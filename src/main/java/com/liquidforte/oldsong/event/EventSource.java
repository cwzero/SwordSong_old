package com.liquidforte.oldsong.event;

import java.util.EventListener;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public interface EventSource {
    <T extends EventListener, U extends T> void addListener(Class<T> listenerClass, U listener);

    <T extends EventListener, U extends T> void removeListener(Class<T> listenerClass, U listener);
}
