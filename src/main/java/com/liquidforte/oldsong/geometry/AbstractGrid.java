package com.liquidforte.oldsong.geometry;

import com.liquidforte.oldsong.gridevent.GridEvent;
import com.liquidforte.oldsong.gridevent.GridListener;

import javax.swing.event.EventListenerList;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public abstract class AbstractGrid<P extends Point, V> extends AbstractMap<P, V> implements Grid<P, V> {
    private final EventListenerList listeners = new EventListenerList();

    @Override
    public <T extends GridListener<P, V>, L extends T> void addGridListener(Class<T> listenerClass, L listener) {
        listeners.add(listenerClass, listener);
    }

    @Override
    public <T extends GridListener<P, V>, L extends T> void removeGridListener(Class<T> listenerClass, L listener) {
        listeners.remove(listenerClass, listener);
    }

    protected <T extends GridListener<P, V>, E extends GridEvent<P, V>> E fireEvent(Class<T> listenerClass, BiPredicate<T, E> filter, BiConsumer<T, E> handler, E event) {
        Executor executor = ForkJoinPool.commonPool();
        Arrays.stream(listeners.getListeners(listenerClass))
                .filter(it -> filter.test(it, event))
                .forEach(it -> executor
                        .execute(() -> handler.accept(it, event)));
        return event;
    }

    protected abstract V doGet(P p);

    protected abstract V doSet(P p, V v);

    protected abstract V doRemove(P p);

    @Override
    public abstract Set<P> keySet();

    public class GridEntrySet extends AbstractSet<Entry<P, V>> {
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
                    AbstractGrid.this.put(prev.key, null);
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

    public class GridEntry implements Entry<P, V>, Pointer<V> {
        private final P key;

        public GridEntry(P key) {
            this.key = key;
        }

        @Override
        public P getKey() {
            return key;
        }

        public V getValue() {
            return AbstractGrid.this.doGet(key);
        }

        @Override
        public V setValue(V value) {
            // TODO: events
            return AbstractGrid.this.doSet(key, value);
        }
    }
}
