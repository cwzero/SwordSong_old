package com.liquidforte.song.grid;

import com.liquidforte.song.event.EventListener;
import com.liquidforte.song.grid.event.FireGridEvent;
import com.liquidforte.song.grid.event.GridEvent;
import com.liquidforte.song.grid.event.GridListener;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;
import com.liquidforte.song.pointer.DestinationPointer;
import com.liquidforte.song.pointer.SourcePointer;

import javax.swing.event.EventListenerList;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractGrid<P extends Point, S extends Size<P>, V> extends AbstractMap<P, V> implements Grid<P, S, V>, FireGridEvent<P, S, V> {
    private final EventListenerList listeners = new EventListenerList();

    @Override
    public <T extends EventListener, L extends T> void addListener(Class<T> listenerClass, L listener) {
        listeners.add(listenerClass, listener);
    }

    @Override
    public <T extends EventListener, L extends T> void removeListener(Class<T> listenerClass, L listener) {
        listeners.remove(listenerClass, listener);
    }

    public <T extends GridListener<P, S, V>, E extends GridEvent<P, S, V>> E fireGridEvent(Class<T> listenerClass, BiPredicate<T, E> filter, BiConsumer<T, E> handler, E event) {
        return fireEvent(listenerClass, filter, handler, event);
    }

    protected <T extends java.util.EventListener, E> E fireEvent(Class<T> listenerClass, BiPredicate<T, E> filter, BiConsumer<T, E> handler, E event) {
        Executor executor = ForkJoinPool.commonPool();
        Arrays.stream(listeners.getListeners(listenerClass))
                .filter(it -> filter.test(it, event))
                .forEach(it -> executor
                        .execute(() -> handler.accept(it, event)));
        return event;
    }

    protected abstract V doGet(Object key);

    protected abstract V doGetValue(P p);

    @Override
    public V get(Object key) {
        return doGet(key);
    }

    @Override
    public V getValue(P p) {
        return doGetValue(p);
    }

    protected abstract V doPutValue(P p, V v);

    @Override
    public V setValue(P p, V v) {
        return doPutValue(p, v);
    }

    @Override
    public V set(P p, V v) {
        return doPutValue(p, v);
    }

    @Override
    public V put(P key, V value) {
        return doPutValue(key, value);
    }

    @Override
    public abstract V remove(Object key);

    protected V doRemove(P p) {
        return doPutValue(p, null);
    }

    @Override
    public V removeKey(P p) {
        return doRemove(p);
    }

    @Override
    public Set<P> keySet() {
        return keyStream().collect(Collectors.toSet());
    }

    protected abstract Stream<P> keyStream();

    @Override
    public Set<Entry<P, V>> entrySet() {
        return new GridEntrySet();
    }

    @Override
    public DestinationPointer<P, V> getDestinationPointer(P p) {
        return new GridEntry(p);
    }

    @Override
    public SourcePointer<P, V> getSourcePointer(P p) {
        return new GridEntry(p);
    }

    public class GridEntrySet extends AbstractSet<Entry<P, V>> implements Grid.GridEntrySet<P, V> {
        @Override
        public Iterator<Entry<P, V>> iterator() {
            return new Iterator<>() {
                private final Iterator<P> keyIterator = keySet().iterator();
                private GridEntry prev;

                @Override
                public boolean hasNext() {
                    return keyIterator.hasNext();
                }

                @Override
                public void remove() {
                    AbstractGrid.this.doRemove(prev.key);
                }

                @Override
                public Entry<P, V> next() {
                    prev = new GridEntry(keyIterator.next());
                    return prev;
                }
            };
        }

        @Override
        public int size() {
            return keySet().size();
        }
    }

    public class GridEntry implements Grid.GridEntry<P, V> {
        private final P key;

        public GridEntry(P key) {
            this.key = key;
        }

        @Override
        public P getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return AbstractGrid.this.doGetValue(key);
        }

        @Override
        public V setValue(V value) {
            return AbstractGrid.this.doPutValue(key, value);
        }
    }
}
