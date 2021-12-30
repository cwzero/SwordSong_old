package com.liquidforte.song.geometry.twod;

import com.liquidforte.song.gridevent.twod.*;
import com.liquidforte.song.pointer.Pointer2D;

import javax.swing.event.EventListenerList;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public abstract class AbstractGrid2D<G extends Grid2D<G, V>, V> extends AbstractMap<Point2D, V> implements Grid2D<G, V> {
    private final EventListenerList listeners = new EventListenerList();

    private final Grid2DRemoveListener<G, V> removeListener = event -> fireEvent(Grid2DRemoveListener.class, Grid2DRemoveListener::filterRemoveEvent, Grid2DRemoveListener::handleRemoveEvent, event);
    private final Grid2DUpdateListener<G, V> updateListener = event -> fireEvent(Grid2DUpdateListener.class, Grid2DUpdateListener::filterUpdateEvent, Grid2DUpdateListener::handleUpdateEvent, event);
    private final Grid2DAddListener<G, V> addListener = event -> fireEvent(Grid2DAddListener.class, Grid2DAddListener::filterAddEvent, Grid2DAddListener::handleAddEvent, event);

    private final Grid2DPointListener<G, V> pointListener = event -> {
        fireEvent(Grid2DPointListener.class, Grid2DPointListener::filterPointEvent, Grid2DPointListener::handlePointEvent, event);
        if (event instanceof Grid2DAddEvent<G, V> addEvent) {
            addListener.handleAddEvent(addEvent);
        }

        if (event instanceof Grid2DRemoveEvent<G, V> removeEvent) {
            removeListener.handleRemoveEvent(removeEvent);
        }

        if (event instanceof Grid2DUpdateEvent<G, V> updateEvent) {
            updateListener.handleUpdateEvent(updateEvent);
        }
    };

    private final Grid2DListener<G, V> listener = event -> {
        fireEvent(Grid2DListener.class, Grid2DListener::filterEvent, Grid2DListener::handleEvent, event);
        if (event instanceof Grid2DPointEvent<G, V> pointEvent) {
            pointListener.handlePointEvent(pointEvent);
        }
    };

    protected void propagateEvents(Grid2DEventSource<G, V> source) {
        source.addGridListener(Grid2DListener.class, listener);
        source.addGridListener(Grid2DAddListener.class, addListener);
        source.addGridListener(Grid2DPointListener.class, pointListener);
        source.addGridListener(Grid2DRemoveListener.class, removeListener);
        source.addGridListener(Grid2DUpdateListener.class, updateListener);
    }

    @Override
    public <T extends Grid2DListener<G, V>, L extends T> void addGridListener(Class<T> listenerClass, L listener) {
        listeners.add(listenerClass, listener);
    }

    @Override
    public <T extends Grid2DListener<G, V>, L extends T> void removeGridListener(Class<T> listenerClass, L listener) {
        listeners.remove(listenerClass, listener);
    }

    protected <T extends Grid2DListener<G, V>, E extends Grid2DEvent<G, V>> E fireEvent(Class<T> listenerClass, BiPredicate<T, E> filter, BiConsumer<T, E> handler, E event) {
        Executor executor = ForkJoinPool.commonPool();
        Arrays.stream(listeners.getListeners(listenerClass))
                .filter(it -> filter.test(it, event))
                .forEach(it -> executor
                        .execute(() -> handler.accept(it, event)));
        return event;
    }

    @Override
    public V get(int x, int y) {
        return doGet(x, y);
    }

    protected abstract V doGet(int x, int y);

    protected abstract V doPut(int x, int y, V v);

    @Override
    @SuppressWarnings("unchecked")
    public V put(int x, int y, V v) {
        V current = doGet(x, y);
        if (v == null && current == null || v != null && v.equals(current)) {
            return v;
        }

        boolean cancelled;
        Point2D pos = new Point2D(x, y);
        if (current == null) {
            Grid2DAddEvent<G, V> event = new Grid2DAddEvent<>((G) this, pos, v);
            fireEvent(Grid2DListener.class, Grid2DListener::filterEvent, Grid2DListener::handleEvent, event);
            fireEvent(Grid2DPointListener.class, Grid2DPointListener::filterPointEvent, Grid2DPointListener::handlePointEvent, event);
            fireEvent(Grid2DAddListener.class, Grid2DAddListener::filterAddEvent, Grid2DAddListener::handleAddEvent, event);

            cancelled = event.isCancelled();
        } else if (v == null) {
            Grid2DRemoveEvent<G, V> event = new Grid2DRemoveEvent<>((G) this, pos, current);
            fireEvent(Grid2DListener.class, Grid2DListener::filterEvent, Grid2DListener::handleEvent, event);
            fireEvent(Grid2DPointListener.class, Grid2DPointListener::filterPointEvent, Grid2DPointListener::handlePointEvent, event);
            fireEvent(Grid2DRemoveListener.class, Grid2DRemoveListener::filterRemoveEvent, Grid2DRemoveListener::handleRemoveEvent, event);

            Grid2DUpdateEvent<G, V> updateEvent = new Grid2DUpdateEvent<>((G) this, pos, current, null);
            fireEvent(Grid2DListener.class, Grid2DListener::filterEvent, Grid2DListener::handleEvent, updateEvent);
            fireEvent(Grid2DPointListener.class, Grid2DPointListener::filterPointEvent, Grid2DPointListener::handlePointEvent, updateEvent);
            fireEvent(Grid2DUpdateListener.class, Grid2DUpdateListener::filterUpdateEvent, Grid2DUpdateListener::handleUpdateEvent, updateEvent);

            cancelled = event.isCancelled();
        } else {
            Grid2DRemoveEvent<G, V> removeEvent = new Grid2DRemoveEvent<>((G) this, pos, current);
            fireEvent(Grid2DListener.class, Grid2DListener::filterEvent, Grid2DListener::handleEvent, removeEvent);
            fireEvent(Grid2DPointListener.class, Grid2DPointListener::filterPointEvent, Grid2DPointListener::handlePointEvent, removeEvent);
            fireEvent(Grid2DRemoveListener.class, Grid2DRemoveListener::filterRemoveEvent, Grid2DRemoveListener::handleRemoveEvent, removeEvent);

            Grid2DAddEvent<G, V> addEvent = new Grid2DAddEvent<>((G) this, pos, v);
            fireEvent(Grid2DListener.class, Grid2DListener::filterEvent, Grid2DListener::handleEvent, addEvent);
            fireEvent(Grid2DPointListener.class, Grid2DPointListener::filterPointEvent, Grid2DPointListener::handlePointEvent, addEvent);
            fireEvent(Grid2DAddListener.class, Grid2DAddListener::filterAddEvent, Grid2DAddListener::handleAddEvent, addEvent);

            Grid2DUpdateEvent<G, V> updateEvent = new Grid2DUpdateEvent<>((G) this, pos, current, v);
            fireEvent(Grid2DListener.class, Grid2DListener::filterEvent, Grid2DListener::handleEvent, updateEvent);
            fireEvent(Grid2DPointListener.class, Grid2DPointListener::filterPointEvent, Grid2DPointListener::handlePointEvent, updateEvent);
            fireEvent(Grid2DUpdateListener.class, Grid2DUpdateListener::filterUpdateEvent, Grid2DUpdateListener::handleUpdateEvent, updateEvent);

            cancelled = removeEvent.isCancelled() || addEvent.isCancelled() || updateEvent.isCancelled();
        }

        if (!cancelled) {
            return doPut(x, y, v);
        }

        return null;
    }

    @Override
    public int getMinX() {
        return 0;
    }

    @Override
    public int getMaxX() {
        return getWidth() - 1;
    }

    @Override
    public int getMinY() {
        return 0;
    }

    @Override
    public int getMaxY() {
        return getHeight() - 1;
    }

    public Set<Point2D> keySet() {
        Stream<Integer> xs = IntStream.rangeClosed(getMinX(), getMaxX()).boxed();
        Stream<Integer> ys = IntStream.rangeClosed(getMinY(), getMaxY()).boxed();

        Stream<Point2D> ps = xs.flatMap(x ->
                ys.map(y -> new Point2D(x, y)));

        return ps.collect(Collectors.toSet());
    }

    @Override
    public Pointer2D<V> getPointer(Point2D pos) {
        return new Grid2DEntry(pos);
    }

    @Override
    public boolean containsKey(int x, int y) {
        return x >= getMinX() && x <= getMaxX() &&
                y >= getMinY() && y <= getMaxY();
    }

    @Override
    public Set<Entry<Point2D, V>> entrySet() {
        return new Grid2DEntrySet();
    }

    private class Grid2DEntrySet extends AbstractSet<Entry<Point2D, V>> {
        @Override
        public Iterator<Entry<Point2D, V>> iterator() {
            return new Iterator<>() {
                private final Iterator<Point2D> keyIterator = keySet().iterator();
                private Grid2DEntry prev;

                @Override
                public boolean hasNext() {
                    return keyIterator.hasNext();
                }

                @Override
                public void remove() {
                    AbstractGrid2D.this.put(prev.key.x(), prev.key.y(), null);
                }

                @Override
                public Entry<Point2D, V> next() {
                    prev = new Grid2DEntry(keyIterator.next());
                    return prev;
                }
            };
        }

        @Override
        public int size() {
            int width = getMaxX() - getMinX() + 1;
            int height = getMaxY() - getMinY() + 1;
            return width * height;
        }
    }

    private class Grid2DEntry implements Entry<Point2D, V>, Pointer2D<V> {
        private final Point2D key;

        public Grid2DEntry(Point2D key) {
            this.key = key;
        }

        @Override
        public Point2D getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return AbstractGrid2D.this.get(key.x(), key.y());
        }

        @Override
        public V setValue(V value) {
            return put(key.x(), key.y(), value);
        }

        @Override
        public int getX() {
            return key.x();
        }

        @Override
        public int getY() {
            return key.y();
        }

        @Override
        public Point2D getPosition() {
            return key;
        }
    }
}
