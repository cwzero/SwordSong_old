package com.liquidforte.song.test.grid.three;

import com.liquidforte.song.grid.three.AbstractGrid3D;
import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.PointSet3D;
import com.liquidforte.song.math.geometry.three.Size3D;

import java.util.function.Function;
import java.util.function.Predicate;

public class AbstractGridTest3D {
    protected class TestGrid3D extends AbstractGrid3D<String> {
        private final String[][][] grid;

        public TestGrid3D(int width, int height, int depth) {
            this(Point3D.space.filter(new Size3D(width, height, depth)), new String[width][height][depth]);
        }

        public TestGrid3D(PointSet3D space, String[][][] grid) {
            super(space);
            this.grid = grid;
        }

        @Override
        protected String doSetValue(Point3D p, String s) {
            String old = grid[p.x()][p.y()][p.z()];
            grid[p.x()][p.y()][p.z()] = s;
            return old;
        }

        @Override
        protected String doGetValue(Point3D p) {
            return grid[p.x()][p.y()][p.z()];
        }

        @Override
        public TestGrid3D map(Function<Point3D, Point3D> mapFn) {
            return new TestGrid3D(space.map(mapFn), grid);
        }

        @Override
        public TestGrid3D filter(Predicate<Point3D> filterFn) {
            return new TestGrid3D(space.filter(filterFn), grid);
        }
    }
}
