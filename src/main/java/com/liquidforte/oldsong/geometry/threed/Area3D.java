package com.liquidforte.oldsong.geometry.threed;

import com.liquidforte.oldsong.pointer.Positional3D;

import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
An area3d can be thought of as marking a cube in space, but it also has an internal offset.
It's more accurately a transformation between two different point representations, a two-way function for transforming points
between an external and internal form.
 */
public record Area3D(Point3D externalOffset, Point3D internalOffset, Size3D size) implements Positional3D, Sized3D {
    public Point3D transformEnter(Point3D external) {
        if (containsExternal(external)) {
            return new Point3D(external.x() - externalOffset.x() + internalOffset.x(),
                    external.y() - externalOffset.y() + internalOffset.y(),
                    external.z() - externalOffset.z() + internalOffset.z());
        }
        return null;
    }

    public Point3D transformExit(Point3D internal) {
        if (containsInternal(internal)) {
            return new Point3D(internal.x() - internalOffset.x() + externalOffset.x(),
                    internal.y() - internalOffset.y() + externalOffset.y(),
                    internal.z() - internalOffset.z() + externalOffset.z());
        }
        return null;
    }

    public boolean containsExternal(Point3D point) {
        return point.x() >= externalOffset.x() && point.x() <= externalOffset().x() + size.width() &&
                point.y() >= externalOffset().y() && point.y() <= externalOffset.y() + size.height() &&
                point.z() >= externalOffset.z() && point.z() <= externalOffset.z() + size.depth();
    }

    public boolean containsInternal(Point3D point) {
        return point.x() >= internalOffset.x() && point.x() <= size.width() + internalOffset.x() &&
                point.y() >= internalOffset.y() && point.y() <= size.height() + internalOffset.y() &&
                point.z() >= internalOffset.z() && point.z() <= size.depth() + internalOffset.z();
    }

    public Stream<Point3D> streamInternal() {
        return IntStream.rangeClosed(internalOffset().x(), internalOffset.x() + size.width()).boxed()
                .flatMap(x -> IntStream.rangeClosed(internalOffset().y(), internalOffset.y() + size.height()).boxed()
                        .flatMap(y -> IntStream.rangeClosed(internalOffset.z(), internalOffset.z() + size.depth()).boxed()
                                .map(z -> new Point3D(x, y, z))));
    }

    public Stream<Point3D> streamExternal() {
        return streamInternal().map(this::transformExit);
    }

    public Stream<Point3D> streamInternalCorners() {
        Predicate<Integer> cornerX = x -> x == internalOffset.x() || x == internalOffset.x() + size.width();
        Predicate<Integer> cornerY = y -> y == internalOffset.y() || y == internalOffset.y() + size.height();
        Predicate<Integer> cornerZ = z -> z == internalOffset.z() || z == internalOffset.z() + size.depth();
        Predicate<Point3D> corner = p -> cornerX.test(p.x()) && cornerY.test(p.y()) && cornerZ.test(p.z());

        return streamInternal().filter(corner);
    }

    public Stream<Point3D> streamExternalCorners() {
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
    public Size3D getSize() {
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
    public Point3D getPosition() {
        return externalOffset;
    }
}
