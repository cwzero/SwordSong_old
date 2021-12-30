package com.liquidforte.song.geometry.twod;

public record Size2D(int width, int height) implements Sized2D {
    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Size2D getSize() {
        return this;
    }
}
