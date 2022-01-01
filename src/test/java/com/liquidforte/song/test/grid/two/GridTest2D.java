package com.liquidforte.song.test.grid.two;

import com.liquidforte.song.grid.two.Grid2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GridTest2D extends AbstractGridTest2D {
    private TestGrid2D grid;

    @BeforeEach
    public void setUp() {
        grid = new TestGrid2D(5, 5);
    }

    @Test
    public void constrain() {
        Grid2D<String> c = grid.constrain(1, 1);
        c.setValue(2, 2, "Test");
        assertThat(c.getValue(2, 2)).isNull();
        c.setValue(0, 0, "Test");
        assertThat(c.getValue(2, 2)).isNull();
        assertThat(c.getValue(0, 0)).isEqualTo("Test");
        assertThat(grid.getValue(2, 2)).isNull();
        assertThat(grid.getValue(0, 0)).isEqualTo("Test");
    }
}
