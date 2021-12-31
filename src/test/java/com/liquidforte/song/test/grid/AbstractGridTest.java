package com.liquidforte.song.test.grid;

import com.liquidforte.song.grid.AbstractGrid;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.PointSet2D;
import com.liquidforte.song.math.geometry.two.PointSpace2D;

import java.util.function.Function;
import java.util.function.Predicate;

public class AbstractGridTest {
    protected class TestGrid extends AbstractGrid<TestGrid, Point2D, String> implements PointSet2D<TestGrid> {
        private PointSpace2D space = PointSpace2D.INSTANCE;
        private final String[][] grid;

        public TestGrid(String[][] grid, PointSpace2D space) {
            this.space = space;
            this.grid = grid;
        }

        public TestGrid(int width, int height) {
            this.grid = new String[width][height];
            space = space.constrain(width, height);
        }

        @Override
        protected String doSetValue(Point2D p, String s) {
            p = space.construct(p);
            if (p == null) {
                return null;
            }
            String result = grid[p.x()][p.y()];
            grid[p.x()][p.y()] = s;
            return result;
        }

        @Override
        protected String doGetValue(Point2D p) {
            p = space.construct(p);
            if (p != null) {
                return grid[p.x()][p.y()];
            }
            return null;
        }

        @Override
        public Point2D construct(int... components) {
            return space.construct(components);
        }

        @Override
        public TestGrid map(Function<Point2D, Point2D> mapFn) {
            return new TestGrid(grid, space.map(mapFn));
        }

        @Override
        public TestGrid filter(Predicate<Point2D> filterFn) {
            return new TestGrid(grid, space.filter(filterFn));
        }
    }
}
