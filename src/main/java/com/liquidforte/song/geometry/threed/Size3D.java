package com.liquidforte.song.geometry.threed;

public record Size3D(int width, int height, int depth) implements Sized3D {
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