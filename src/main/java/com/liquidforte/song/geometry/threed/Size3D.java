package com.liquidforte.song.geometry.threed;

import com.liquidforte.song.geometry.Size;

public record Size3D(int width, int height, int depth) implements Size, Vector3D, Sized3D {
    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getDepth() {
        return depth;
    }

    @Override
    public Size3D getSize() {
        return this;
    }
}
