package com.liquidforte.song.test.grid;

import com.liquidforte.song.grid.AbstractGrid;
import com.liquidforte.song.math.geometry.Point;
import com.liquidforte.song.math.geometry.Size;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AbstractGridTest {
    protected static record TestPoint(int x) implements Point<TestPoint> {
        @Override
        public TestPoint add(TestPoint other) {
            return new TestPoint(this.x + other.x);
        }

        @Override
        public TestPoint invert() {
            return new TestPoint(-x);
        }
    }

    protected static record TestSize(int size) implements Size<TestPoint, TestSize> {
        @Override
        public Stream<TestPoint> getPointStream() {
            return IntStream.rangeClosed(0, size).boxed().map(TestPoint::new);
        }

        @Override
        public boolean contains(TestPoint point) {
            return point.x >= 0 && point.x < size;
        }

        @Override
        public TestSize add(TestSize other) {
            return new TestSize(this.size + other.size);
        }

        @Override
        public TestSize invert() {
            return new TestSize(-1);
        }
    }

    protected static class TestGrid extends AbstractGrid<TestPoint, TestSize, String> {
        private final String[] grid;

        public TestGrid(int size) {
            this.grid = new String[size];
        }

        @Override
        protected String doGet(Object key) {
            if (key instanceof TestPoint p) {
                return doGetValue(p);
            }
            return null;
        }

        @Override
        protected String doGetValue(TestPoint testPoint) {
            return grid[testPoint.x];
        }

        @Override
        protected String doPutValue(TestPoint testPoint, String s) {
            String o = grid[testPoint.x];
            grid[testPoint.x] = s;
            return o;
        }

        @Override
        public String remove(Object key) {
            if (key instanceof TestPoint p) {
                return doPutValue(p, null);
            }
            return null;
        }

        @Override
        public boolean containsKey(Object key) {
            if (key instanceof TestPoint p) {
                return contains(p);
            }
            return false;
        }

        @Override
        protected Stream<TestPoint> keyStream() {
            return IntStream.rangeClosed(0, grid.length).boxed().map(TestPoint::new);
        }

        @Override
        public TestSize getSize() {
            return new TestSize(grid.length);
        }
    }
}
