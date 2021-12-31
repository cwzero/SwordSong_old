package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.Space;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Space2D(Point2D location, Size2D size,
                      Point2D internalOffset) implements Space<Point2D, Size2D>, Rectangle {
    @Override
    public Point2D getInternalOffset() {
        return internalOffset;
    }

    @Override
    public Point2D transformExternal(Point2D point) {
        return point.subtract(location).add(internalOffset);
    }

    @Override
    public Point2D transformInternal(Point2D point) {
        return point.subtract(internalOffset).add(location);
    }

    @Override
    public boolean containsExternal(Point2D point) {
        return point.x() >= location.x() && point.x() < location.x() + size.width() &&
                point.y() >= location.y() && point.y() < location.y() + size.height();
    }

    @Override
    public boolean containsInternal(Point2D point) {
        return point.x() >= internalOffset.x() && point.x() < internalOffset.x() + size.width() &&
                point.y() >= internalOffset.y() && point.y() < internalOffset.y() + size.height();
    }

    @Override
    public Stream<Point2D> streamExternal() {
        return streamExternalX().boxed().flatMap(x ->
                streamExternalY().boxed().map(y ->
                        new Point2D(x, y)));
    }

    @Override
    public Stream<Point2D> streamInternal() {
        return streamInternalX().boxed().flatMap(x ->
                streamInternalY().boxed().map(y ->
                        new Point2D(x, y)));
    }

    public IntStream streamExternalX() {
        return IntStream.rangeClosed(location.x(), location.x() + size.width());
    }

    public IntStream streamInternalX() {
        return IntStream.rangeClosed(internalOffset.x(), internalOffset.x() + size.width());
    }

    public IntStream streamExternalY() {
        return IntStream.rangeClosed(location.y(), location.y() + size.height());
    }

    public IntStream streamInternalY() {
        return IntStream.rangeClosed(internalOffset.y(), internalOffset.y() + size.height());
    }

    @Override
    public Point2D getLocation() {
        return location;
    }

    @Override
    public Size2D getSize() {
        return size;
    }
}