package com.liquidforte.song.test.grid.two;

import com.liquidforte.song.grid.two.AbstractGrid2D;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.PointSet2D;

import java.util.function.Function;
import java.util.function.Predicate;

public class AbstractGridTest2D {
    protected class TestGrid2D extends AbstractGrid2D<String> {
        private final String[][] grid;

        public TestGrid2D(int width, int height) {
            this(Point2D.space.constrain(width, height), new String[width][height]);
        }

        public TestGrid2D(PointSet2D space, String[][] grid) {
            super(space);
            this.grid = grid;
        }

        @Override
        protected String doSetValue(Point2D p, String s) {
            String old = grid[p.x()][p.y()];
            grid[p.x()][p.y()] = s;
            return old;
        }

        @Override
        protected String doGetValue(Point2D p) {
            return grid[p.x()][p.y()];
        }

        @Override
        public TestGrid2D map(Function<Point2D, Point2D> mapFn) {
            return new TestGrid2D(space.map(mapFn), grid);
        }

        @Override
        public TestGrid2D filter(Predicate<Point2D> filterFn) {
            return new TestGrid2D(space.filter(filterFn), grid);
        }
    }
}
