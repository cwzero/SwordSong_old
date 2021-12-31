package com.liquidforte.song.math.geometry;

public interface Vector<V extends Vector<V>> {
    V add(V other);

    V scale(double scalar);

    double dot(V other);

    default V subtract(V other) {
        return add(scale(-1));
    }

    int component(int axis);

    int[] components(int[] axis);

    int[] components();

    int dimensions();

    V withComponent(int axis, int component);

    V withComponents(int[] axis, int[] component);
}
