package com.liquidforte.song.test.math.geometry.two;

import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.PointSet2D;
import com.liquidforte.song.math.geometry.two.Size2D;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Point2DTest {
    @Test
    public void offset() {
        Point2D translated = Point2D.space
                .map(new Point2D(1, 1))
                .construct(0, 0);
        assertThat(translated).isEqualTo(new Point2D(1, 1));
    }

    @Test
    public void constrain() {
        PointSet2D c = Point2D.space.filter(new Size2D(0, 0));
        assertThat(c.construct(0, 0)).isEqualTo(null);
    }
}
