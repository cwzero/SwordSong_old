package com.liquidforte.song.test.grid;

import com.liquidforte.song.math.geometry.two.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GridTest extends AbstractGridTest {
    private TestGrid grid;

    @BeforeEach
    public void setUp() {
        grid = new TestGrid(5, 5);
    }

    @Test
    public void constrain() {
        TestGrid c = grid.constrain(1, 1);
        c.setValue(Point2D.of(2, 2), "Test");
        assertThat(c.getValue(Point2D.of(2, 2))).isNull();
        c.setValue(Point2D.of(0, 0), "Test");
        assertThat(c.getValue(Point2D.of(2, 2))).isNull();
        assertThat(c.getValue(Point2D.of(0, 0))).isEqualTo("Test");
        assertThat(grid.getValue(Point2D.of(2, 2))).isNull();
        assertThat(grid.getValue(Point2D.of(0, 0))).isEqualTo("Test");
    }
}
