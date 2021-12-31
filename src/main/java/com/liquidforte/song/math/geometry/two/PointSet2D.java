package com.liquidforte.song.math.geometry.two;

import com.liquidforte.song.math.geometry.Constrain;
import com.liquidforte.song.math.geometry.Offset;
import com.liquidforte.song.math.geometry.PointSet;

import java.util.function.Function;
import java.util.function.Predicate;

public interface PointSet2D extends VectorSet2D<Point2D>, PointSet<Point2D> {
    @Override
    default PointSet2D filter(Predicate<Point2D> filterFn) {
        return components -> {
            Point2D result = construct(components);
            if (filterFn.test(result)) {
                return result;
            }
            return null;
        };
    }

    @Override
    default PointSet2D constrain(Constrain<Point2D> constraint) {
        return map(constraint::apply);
    }

    default PointSet2D constrain(int width, int height) {
        return constrain(Size2D.of(width, height));
    }

    @Override
    default PointSet2D offset(Offset<Point2D> offset) {
        return map(offset::apply);
    }

    default PointSet2D offset(int x, int y) {
        return offset(Point2D.of(x, y));
    }

    @Override
    default PointSet2D map(Function<Point2D, Point2D> mapFn) {
        return components -> mapFn.apply(construct(components));
    }

    @Override
    default PointSet2D add(Point2D other) {
        return map(p -> p.add(other));
    }

    @Override
    default PointSet2D scale(double scalar) {
        return map(p -> p.scale(scalar));
    }

    @Override
    default PointSet2D subtract(Point2D other) {
        return map(p -> p.subtract(other));
    }
}
