package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.Area;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Area3D(Point3D location, Size3D size, Point3D internalOffset) implements Area<Point3D, Size3D>, Cube {
    @Override
    public Point3D getInternalOffset() {
        return internalOffset;
    }

    @Override
    public Point3D transformExternal(Point3D point) {
        return point.subtract(location).add(internalOffset);
    }

    @Override
    public Point3D transformInternal(Point3D point) {
        return point.subtract(internalOffset).add(location);
    }

    @Override
    public boolean containsExternal(Point3D point) {
        return point.x() >= location.x() && point.x() < location.x() + size.width() &&
                point.y() >= location.y() && point.y() < location.y() + size.height() &&
                point.x() >= location.z() && point.z() < location.z() + size.depth();
    }

    @Override
    public boolean containsInternal(Point3D point) {
        return point.x() >= internalOffset.x() && point.x() < internalOffset.x() + size.width() &&
                point.y() >= internalOffset.y() && point.y() < internalOffset.y() + size.height() &&
                point.z() >= internalOffset.z() && point.z() < internalOffset.z() + size.depth();
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

    public IntStream streamExternalZ() {
        return IntStream.rangeClosed(location.z(), location.z() + size.depth());
    }

    public IntStream streamInternalZ() {
        return IntStream.rangeClosed(internalOffset.z(), internalOffset.z() + size.depth());
    }

    @Override
    public Stream<Point3D> streamExternal() {
        return streamExternalX().boxed().flatMap(x ->
                streamExternalY().boxed().flatMap(y ->
                        streamExternalZ().boxed().map(z ->
                                new Point3D(x, y, z))));
    }

    @Override
    public Stream<Point3D> streamInternal() {
        return streamInternalX().boxed().flatMap(x ->
                streamInternalY().boxed().flatMap(y ->
                        streamInternalZ().boxed().map(z ->
                                new Point3D(x, y, z))));
    }

    @Override
    public Point3D getLocation() {
        return location;
    }

    @Override
    public Size3D getSize() {
        return size;
    }
}
