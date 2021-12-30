package com.liquidforte.song.geometry.twod;

import com.liquidforte.song.geometry.Size;

public record Size2D(int width, int height) implements Size, Vector2D, Sized2D {
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
