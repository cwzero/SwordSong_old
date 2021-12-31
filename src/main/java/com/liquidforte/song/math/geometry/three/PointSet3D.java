package com.liquidforte.song.math.geometry.three;

import com.liquidforte.song.math.geometry.Constrain;
import com.liquidforte.song.math.geometry.Offset;
import com.liquidforte.song.math.geometry.PointSet;

import java.util.function.Function;
import java.util.function.Predicate;

public interface PointSet3D extends VectorSet3D<Point3D>, PointSet<Point3D> {
    @Override
    default PointSet3D filter(Predicate<Point3D> filterFn) {
        return components -> {
            Point3D result = construct(components);
            if (filterFn.test(result)) {
                return result;
            }
            return null;
        };
    }

    @Override
    default PointSet3D constrain(Constrain<Point3D> constraint) {
        return map(constraint::apply);
    }

    default PointSet3D constrain(int width, int height, int depth) {
        return constrain(Size3D.of(width, height, depth));
    }

    @Override
    default PointSet3D offset(Offset<Point3D> offset) {
        return map(offset::apply);
    }

    default PointSet3D offset(int x, int y, int z) {
        return offset(Point3D.of(x, y, z));
    }

    @Override
    default PointSet3D map(Function<Point3D, Point3D> mapFn) {
        return components -> mapFn.apply(construct(components));
    }

    @Override
    default PointSet3D add(Point3D other) {
        return map(v -> v.add(other));
    }

    @Override
    default PointSet3D scale(double scalar) {
        return map(v -> v.scale(scalar));
    }

    @Override
    default PointSet3D subtract(Point3D other) {
        return map(v -> v.subtract(other));
    }
}
