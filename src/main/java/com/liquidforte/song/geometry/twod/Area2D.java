package com.liquidforte.song.geometry.twod;

import com.liquidforte.song.geometry.threed.Point3D;
import com.liquidforte.song.pointer.Positional2D;

import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
An area2d can be thought of as marking a rectangle on screen, but it also has an internal offset.
It's more accurately a transformation between two different point representations, a two-way function for transforming points
between an external and internal form.
 */
public record Area2D(Point2D externalOffset, Point2D internalOffset, Size2D size) implements Positional2D, Sized2D {
    public Point2D transformEnter(Point2D external) {
        if (containsExternal(external)) {
            return new Point2D(external.x() - externalOffset.x() + internalOffset.x(), external.y() - externalOffset.y() + internalOffset.y());
        }
        return null;
    }

    public Point2D transformExit(Point2D internal) {
        if (containsInternal(internal)) {
            return new Point2D(internal.x() - internalOffset.x() + externalOffset.x(), internal.y() - internalOffset.y() + externalOffset.y());
        }
        return null;
    }

    public boolean containsExternal(Point2D point) {
        return point.x() >= externalOffset.x() && point.x() <= externalOffset.x() + size.width() &&
                point.y() >= externalOffset().y() && point.y() <= externalOffset.y() + size.height();
    }

    public boolean containsInternal(Point2D point) {
        return point.x() >= internalOffset.x() && point.x() <= size.width() + internalOffset.x() &&
                point.y() >= internalOffset.y() && point.y() <= size.height() + internalOffset.y();
    }

    public Stream<Point2D> streamInternal() {
        return IntStream.rangeClosed(internalOffset().x(), internalOffset.x() + size.width()).boxed()
                .flatMap(x -> IntStream.rangeClosed(internalOffset().y(), internalOffset.y() + size.height()).boxed()
                        .map(y -> new Point2D(x, y)));
    }

    public Stream<Point2D> streamExternal() {
        return streamInternal().map(this::transformExit);
    }

    public Stream<Point2D> streamInternalCorners() {
        Predicate<Integer> cornerX = x -> x == internalOffset.x() || x == internalOffset.x() + size.width();
        Predicate<Integer> cornerY = y -> y == internalOffset.y() || y == internalOffset.y() + size.height();
        Predicate<Point2D> corner = p -> cornerX.test(p.x()) && cornerY.test(p.y());

        return streamInternal().filter(corner);
    }

    public Stream<Point2D> streamExternalCorners() {
        return streamInternalCorners().map(this::transformExit);
    }

    @Override
    public int getWidth() {
        return size.width();
    }

    @Override
    public int getHeight() {
        return size.height();
    }

    @Override
    public Size2D getSize() {
        return size;
    }

    @Override
    public int getX() {
        return externalOffset().x();
    }

    @Override
    public int getY() {
        return externalOffset.y();
    }

    @Override
    public Point2D getPosition() {
        return externalOffset;
    }
}
