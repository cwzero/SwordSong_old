package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.Size;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Size2D(int width, int height) implements Vector2D<Size2D>, Size<Point2D, Size2D>, Sized2D {
    @Override
    public Size2D add(Size2D other) {
        return new Size2D(this.width + other.width, this.height + other.height);
    }

    public IntStream streamX() {
        return IntStream.rangeClosed(0, width);
    }

    public IntStream streamY() {
        return IntStream.rangeClosed(0, height);
    }

    @Override
    public Stream<Point2D> getPointStream() {
        return streamX().boxed().flatMap(x ->
                streamY().boxed().map(y ->
                        new Point2D(x, y)));
    }

    @Override
    public boolean contains(Point2D point) {
        return point.x() >= 0 && point.x() < width &&
                point.y() >= 0 && point.y() < height;
    }

    @Override
    public Size2D invert() {
        return new Size2D(-width, -height);
    }

    @Override
    public int count() {
        return width * height;
    }
}
