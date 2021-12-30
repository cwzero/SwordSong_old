package com.liquidforte.oldsong.geometry.threed;

@FunctionalInterface
public interface Array3DCreator<T> {
    default T[][][] create(Size3D size) {
        return create(size.width(), size.height(), size.depth());
    }

    T[][][] create(int width, int height, int depth);
}
