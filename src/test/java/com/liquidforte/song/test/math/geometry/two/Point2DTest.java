package com.liquidforte.song.test.math.geometry.two;

import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.PointSpace2D;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Point2DTest {
    @Test
    public void test() {
        Point2D translated = PointSpace2D.INSTANCE
                .offset(1, 1)
                .construct(0, 0);
        assertThat(translated).isEqualTo(Point2D.of(1, 1));
    }

    @Test
    public void test2() {
        Point2D result = PointSpace2D.INSTANCE
                .constrain(0, 0)
                .getOrigin();
        assertThat(result).isNull();
    }
}
