package com.liquidforte.song.math.geometry;

@SuppressWarnings("unchecked")
public interface Vector<V extends Vector<V>> extends Offset<V> {
    V add(V other);

    V scale(double scalar);

    double dot(V other);

    default V subtract(V other) {
        return add(scale(-1));
    }

    int getComponent(int axis);

    int getDimensions();

    @Override
    default V getOffset() {
        return (V) this;
    }
}
