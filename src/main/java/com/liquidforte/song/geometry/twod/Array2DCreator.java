package com.liquidforte.song.geometry.twod;

@FunctionalInterface
public interface Array2DCreator<T> {
    default T[][] create(Size2D size) {
        return create(size.width(), size.height());
    }

    T[][] create(int width, int height);
}
