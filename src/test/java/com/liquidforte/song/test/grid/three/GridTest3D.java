package com.liquidforte.song.test.grid.three;

import com.liquidforte.song.grid.three.Grid3D;
import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.Size3D;
import com.liquidforte.song.pointer.DestinationPointer;
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
        Grid3D<String> c = grid.filter(new Size3D(1, 1, 1));
        c.setValue(2, 2, 2, "Test");
        assertThat(c.getValue(2, 2, 2)).isNull();
        c.setValue(0, 0, 0, "Test");
        assertThat(c.getValue(2, 2, 2)).isNull();
        assertThat(c.getValue(0, 0, 0)).isEqualTo("Test");
        assertThat(grid.getValue(2, 2, 2)).isNull();
        assertThat(grid.getValue(0, 0, 0)).isEqualTo("Test");
    }

    @Test
    public void pointer() {
        Grid3D<String> p = grid.filter(new Size3D(1, 1, 1));
        DestinationPointer<Point3D, String> pointer = p.getDestinationPointer(new Point3D(0, 0, 0));
        pointer.setValue("Test");
        assertThat(grid.getValue(1, 1, 1)).isEqualTo("Test");
    }
}
