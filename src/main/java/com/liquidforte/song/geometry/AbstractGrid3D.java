package com.liquidforte.song.geometry;

import com.liquidforte.song.gridevent.threed.*;
import com.liquidforte.song.pointer.Pointer3D;

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
public abstract class AbstractGrid3D<G extends Grid3D<G, V>, V> extends AbstractMap<Point3D, V> implements Grid3D<G, V> {
    private final EventListenerList listeners = new EventListenerList();

    private final Grid3DRemoveListener<G, V> removeListener = event -> fireEvent(Grid3DRemoveListener.class, Grid3DRemoveListener::filterRemoveEvent, Grid3DRemoveListener::handleRemoveEvent, event);
    private final Grid3DUpdateListener<G, V> updateListener = event -> fireEvent(Grid3DUpdateListener.class, Grid3DUpdateListener::filterUpdateEvent, Grid3DUpdateListener::handleUpdateEvent, event);
    private final Grid3DAddListener<G, V> addListener = event -> fireEvent(Grid3DAddListener.class, Grid3DAddListener::filterAddEvent, Grid3DAddListener::handleAddEvent, event);

    private final Grid3DPointListener<G, V> pointListener = event -> {
        fireEvent(Grid3DPointListener.class, Grid3DPointListener::filterPointEvent, Grid3DPointListener::handlePointEvent, event);
        if (event instanceof Grid3DAddEvent<G, V> addEvent) {
            addListener.handleAddEvent(addEvent);
        }

        if (event instanceof Grid3DRemoveEvent<G, V> removeEvent) {
            removeListener.handleRemoveEvent(removeEvent);
        }

        if (event instanceof Grid3DUpdateEvent<G, V> updateEvent) {
            updateListener.handleUpdateEvent(updateEvent);
        }
    };

    private final Grid3DListener<G, V> listener = event -> {
        fireEvent(Grid3DListener.class, Grid3DListener::filterEvent, Grid3DListener::handleEvent, event);
        if (event instanceof Grid3DPointEvent<G, V> pointEvent) {
            pointListener.handlePointEvent(pointEvent);
        }
    };

    protected void propagateEvents(Grid3DEventSource<G, V> source) {
        source.addGridListener(Grid3DListener.class, listener);
        source.addGridListener(Grid3DAddListener.class, addListener);
        source.addGridListener(Grid3DPointListener.class, pointListener);
        source.addGridListener(Grid3DRemoveListener.class, removeListener);
        source.addGridListener(Grid3DUpdateListener.class, updateListener);
    }

    @Override
    public <T extends Grid3DListener<G, V>, L extends T> void addGridListener(Class<T> listenerClass, L listener) {
        listeners.add(listenerClass, listener);
    }

    @Override
    public <T extends Grid3DListener<G, V>, L extends T> void removeGridListener(Class<T> listenerClass, L listener) {
        listeners.remove(listenerClass, listener);
    }

    protected <T extends Grid3DListener<G, V>, E extends Grid3DEvent<G, V>> void fireEvent(Class<T> listenerClass, BiPredicate<T, E> filter, BiConsumer<T, E> handler, E event) {
        Executor executor = ForkJoinPool.commonPool();
        Arrays.stream(listeners.getListeners(listenerClass))
                .filter(it -> filter.test(it, event))
                .forEach(it -> executor
                        .execute(() -> handler.accept(it, event)));
    }

    protected abstract V doGet(int x, int y, int z);

    protected abstract V doPut(int x, int y, int z, V v);

    @Override
    public V get(int x, int y, int z) {
        return doGet(x, y, z);
    }

    @Override
    @SuppressWarnings("unchecked")
    public V put(int x, int y, int z, V v) {
        V current = doGet(x, y, z);
        if (v == null && current == null || v != null && v.equals(current)) {
            return v;
        }

        boolean cancelled;
        Point3D pos = new Point3D(x, y, z);
        if (current == null) {
            Grid3DAddEvent<G, V> event = new Grid3DAddEvent<>((G) this, pos, v);
            fireEvent(Grid3DListener.class, Grid3DListener::filterEvent, Grid3DListener::handleEvent, event);
            fireEvent(Grid3DPointListener.class, Grid3DPointListener::filterPointEvent, Grid3DPointListener::handleEvent, event);
            fireEvent(Grid3DAddListener.class, Grid3DAddListener::filterAddEvent, Grid3DAddListener::handleAddEvent, event);

            cancelled = event.isCancelled();
        } else if (v == null) {
            Grid3DRemoveEvent<G, V> event = new Grid3DRemoveEvent<>((G) this, pos, current);
            fireEvent(Grid3DListener.class, Grid3DListener::filterEvent, Grid3DListener::handleEvent, event);
            fireEvent(Grid3DPointListener.class, Grid3DPointListener::filterPointEvent, Grid3DPointListener::handleEvent, event);
            fireEvent(Grid3DRemoveListener.class, Grid3DRemoveListener::filterRemoveEvent, Grid3DRemoveListener::handleRemoveEvent, event);

            cancelled = event.isCancelled();
        } else {
            Grid3DRemoveEvent<G, V> removeEvent = new Grid3DRemoveEvent<>((G) this, pos, current);
            fireEvent(Grid3DListener.class, Grid3DListener::filterEvent, Grid3DListener::handleEvent, removeEvent);
            fireEvent(Grid3DPointListener.class, Grid3DPointListener::filterPointEvent, Grid3DPointListener::handleEvent, removeEvent);
            fireEvent(Grid3DRemoveListener.class, Grid3DRemoveListener::filterRemoveEvent, Grid3DRemoveListener::handleRemoveEvent, removeEvent);

            Grid3DAddEvent<G, V> addEvent = new Grid3DAddEvent<>((G) this, pos, v);
            fireEvent(Grid3DListener.class, Grid3DListener::filterEvent, Grid3DListener::handleEvent, addEvent);
            fireEvent(Grid3DPointListener.class, Grid3DPointListener::filterPointEvent, Grid3DPointListener::handleEvent, addEvent);
            fireEvent(Grid3DAddListener.class, Grid3DAddListener::filterAddEvent, Grid3DAddListener::handleAddEvent, addEvent);

            Grid3DUpdateEvent<G, V> updateEvent = new Grid3DUpdateEvent<>((G) this, pos, current, v);
            fireEvent(Grid3DListener.class, Grid3DListener::filterEvent, Grid3DListener::handleEvent, updateEvent);
            fireEvent(Grid3DPointListener.class, Grid3DPointListener::filterPointEvent, Grid3DPointListener::handleEvent, updateEvent);
            fireEvent(Grid3DUpdateListener.class, Grid3DUpdateListener::filterUpdateEvent, Grid3DUpdateListener::handleUpdateEvent, updateEvent);

            cancelled = removeEvent.isCancelled() || addEvent.isCancelled() || updateEvent.isCancelled();
        }

        if (!cancelled) {
            return doPut(x, y, z, v);
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

    @Override
    public int getMinZ() {
        return 0;
    }

    @Override
    public int getMaxZ() {
        return getDepth() - 1;
    }

    @Override
    public boolean containsKey(int x, int y, int z) {
        return x >= getMinX() && x <= getMaxX() &&
                y >= getMinY() && y <= getMaxY() &&
                z >= getMinZ() && z <= getMaxZ();
    }

    @Override
    public Pointer3D<V> getPointer(Point3D pos) {
        return new Grid3DEntry(pos);
    }

    @Override
    public Set<Point3D> keySet() {
        Stream<Integer> xs = IntStream.rangeClosed(getMinX(), getMaxX()).boxed();
        Stream<Integer> ys = IntStream.rangeClosed(getMinY(), getMaxY()).boxed();
        Stream<Integer> zs = IntStream.rangeClosed(getMinZ(), getMaxZ()).boxed();

        Stream<Point3D> ps =
                xs.flatMap(x ->
                        ys.flatMap(y ->
                                zs.map(z ->
                                        new Point3D(x, y, z))));

        return ps.collect(Collectors.toSet());
    }

    @Override
    public Set<Entry<Point3D, V>> entrySet() {
        return new Grid3DEntrySet();
    }

    private class Grid3DEntrySet extends AbstractSet<Entry<Point3D, V>> {

        @Override
        public Iterator<Entry<Point3D, V>> iterator() {
            return new Iterator<>() {
                private final Iterator<Point3D> keyIterator = keySet().iterator();
                private Grid3DEntry prev;

                @Override
                public boolean hasNext() {
                    return keyIterator.hasNext();
                }

                @Override
                public void remove() {
                    AbstractGrid3D.this.put(prev.key.x(), prev.key.y(), prev.key.z(), null);
                }

                @Override
                public Entry<Point3D, V> next() {
                    prev = new Grid3DEntry(keyIterator.next());
                    return prev;
                }
            };
        }

        @Override
        public int size() {
            int width = getMaxX() - getMinX() + 1;
            int height = getMaxY() - getMinY() + 1;
            int depth = getMaxZ() - getMinZ() + 1;
            return width * height * depth;
        }
    }

    private class Grid3DEntry implements Entry<Point3D, V>, Pointer3D<V> {
        private final Point3D key;

        public Grid3DEntry(Point3D key) {
            this.key = key;
        }

        @Override
        public Point3D getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return get(key.x(), key.y(), key.z());
        }

        @Override
        public V setValue(V value) {
            return put(key.x(), key.y(), key.z(), value);
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
        public int getZ() {
            return key.z();
        }

        @Override
        public Point3D getPosition() {
            return key;
        }
    }
}
