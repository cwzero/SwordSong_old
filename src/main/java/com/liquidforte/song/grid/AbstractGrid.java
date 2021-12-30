package com.liquidforte.song.grid;

import com.liquidforte.song.event.EventListener;
import com.liquidforte.song.grid.event.*;
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

public abstract class AbstractGrid<P extends Point<P>, S extends Size<P, S>, V> extends AbstractMap<P, V> implements Grid<P, S, V>, FireGridEvent<P, S, V> {
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

    @Override
    public V put(P key, V value) {
        return putValue(key, value);
    }

    protected abstract V doPutValue(P p, V v);

    @Override
    public V putValue(P p, V v) {
        V currentValue = get(p);

        if (Objects.equals(currentValue, v)) {
            return currentValue;
        }

        V result = doPutValue(p, v);

        if (currentValue == null) {
            fireGridAddEvent(new DefaultGridAddEvent<>(this, p, v));
        } else if (v == null) {
            fireGridRemoveEvent(new DefaultGridRemoveEvent<>(this, p, currentValue));
        } else {
            fireGridUpdateEvent(new DefaultGridUpdateEvent<>(this, p, currentValue, v));
        }

        return result;
    }

    @Override
    public abstract V remove(Object key);

    @Override
    public Set<P> keySet() {
        return keyStream().collect(Collectors.toSet());
    }

    @Override
    public abstract boolean containsKey(Object key);

    @Override
    public boolean contains(P point) {
        return getSize().contains(point);
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
                    AbstractGrid.this.remove(prev.key);
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
            return AbstractGrid.this.getValue(key);
        }

        @Override
        public V setValue(V value) {
            return AbstractGrid.this.setValue(key, value);
        }
    }
}
