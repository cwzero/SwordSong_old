package com.liquidforte.song.test.grid;

import com.liquidforte.song.grid.two.AbstractGrid2D;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.PointSpace2D;

public class AbstractGridTest {
    protected class TestGrid extends AbstractGrid2D<String> {
        private final String[][] grid;

        public TestGrid(PointSpace2D space, String[][] grid) {
            super(space);
            this.grid = grid;
        }

        public TestGrid(String[][] grid) {
            super(PointSpace2D.INSTANCE.constrain(grid.length, grid[0].length));
            this.grid = grid;
        }

        public TestGrid(int width, int height) {
            super(PointSpace2D.INSTANCE.constrain(width, height));
            this.grid = new String[width][height];
        }

        @Override
        protected String doSetValue(Point2D p, String s) {
            if (p == null) {
                return null;
            }
            String result = grid[p.x()][p.y()];
            grid[p.x()][p.y()] = s;
            return result;
        }

        @Override
        protected String doGetValue(Point2D p) {
            if (p != null) {
                return grid[p.x()][p.y()];
            }
            return null;
        }

        @Override
        protected TestGrid construct(PointSpace2D space) {
            return new TestGrid(space, grid);
        }
    }
}
