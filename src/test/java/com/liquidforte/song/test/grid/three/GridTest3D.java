package com.liquidforte.song.test.grid.three;

import com.liquidforte.song.grid.three.Grid3D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GridTest3D extends AbstractGridTest3D {
    private TestGrid3D grid;

    @BeforeEach
    public void setUp() {
        this.grid = new TestGrid3D(5, 5, 5);
    }

    @Test
    public void constrain() {
        Grid3D<String> c = grid.constrain(1, 1, 1);
        c.setValue(2, 2, 2, "Test");
        assertThat(c.getValue(2, 2, 2)).isNull();
        c.setValue(0, 0, 0, "Test");
        assertThat(c.getValue(2, 2, 2)).isNull();
        assertThat(c.getValue(0, 0, 0)).isEqualTo("Test");
        assertThat(grid.getValue(2, 2, 2)).isNull();
        assertThat(grid.getValue(0, 0, 0)).isEqualTo("Test");
    }
}
