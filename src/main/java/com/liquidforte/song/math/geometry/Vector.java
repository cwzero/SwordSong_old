package com.liquidforte.song.math.geometry;

public interface Vector {
    Vector add(Vector other);

    Vector scale(double scalar);

    double dot(Vector other);

    Vector subtract(Vector other);
}
