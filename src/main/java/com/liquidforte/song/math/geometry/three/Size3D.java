package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.Size;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Size3D(int width, int height, int depth) implements Vector3D<Size3D>, Size<Point3D, Size3D>, Sized3D {
    public IntStream streamX() {
        return IntStream.rangeClosed(0, width);
    }

    public IntStream streamY() {
        return IntStream.rangeClosed(0, height);
    }

    public IntStream streamZ() {
        return IntStream.rangeClosed(0, depth);
    }

    @Override
    public Stream<Point3D> getPointStream() {
        return streamX().boxed().flatMap(x ->
                streamY().boxed().flatMap(y ->
                        streamZ().boxed().map(z ->
                                new Point3D(x, y, z))));
    }

    @Override
    public boolean contains(Point3D point) {
        return point.x() >= 0 && point.x() < width &&
                point.y() >= 0 && point.y() < height &&
                point.z() >= 0 && point.z() < depth;
    }

    @Override
    public Size3D add(Size3D other) {
        return new Size3D(this.width + other.width, this.height + other.height, this.depth + other.depth);
    }

    @Override
    public Size3D invert() {
        return new Size3D(-width, -height, -depth);
    }

    @Override
    public int count() {
        return width * height * depth;
    }
}
