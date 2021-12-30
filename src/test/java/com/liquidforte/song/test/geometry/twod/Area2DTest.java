package com.liquidforte.song.test.geometry.twod;

import com.liquidforte.song.geometry.twod.Area2D;
import com.liquidforte.song.geometry.twod.Point2D;
import com.liquidforte.song.geometry.twod.Size2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class Area2DTest {
    private Area2D area;

    @BeforeEach
    void setUp() {
        Point2D externalOffset = new Point2D(1, 1);
        Point2D internalOffset = new Point2D(2, 2);
        Size2D size = new Size2D(3, 3);
        area = new Area2D(externalOffset, internalOffset, size);
    }

    @Test
    void transformEnter() {
        Point2D external = new Point2D(1, 1);
        Point2D internal = new Point2D(2, 2);
        assertThat(area.transformEnter(external)).isEqualTo(internal);
    }

    @Test
    void transformExit() {
        Point2D external = new Point2D(1, 1);
        Point2D internal = new Point2D(2, 2);
        assertThat(area.transformExit(internal)).isEqualTo(external);
    }

    @Test
    void containsExternal() {
        Point2D[] points = {
                new Point2D(1, 1), // Upper Left Corner
                new Point2D(4, 1), // Upper Right Corner
                new Point2D(4, 4), // Lower Right Corner
                new Point2D(1, 4) // Lower Left Corner
        };

        for (Point2D point : points) {
            assertThat(area.containsExternal(point)).isTrue();
        }
    }

    @Test
    void doesntContainExternal() {
        Point2D[] points = {
                new Point2D(0, 0), // Upper Left Corner + up, left
                new Point2D(5, 0), // Upper Right Corner + up, right
                new Point2D(5, 5), // Lower Right Corner + down, right
                new Point2D(0, 5), // Lower Left Corner + down, left
                new Point2D(1, 0), // Upper Left Corner + up
                new Point2D(4, 0), // Upper Right Corner + up
                new Point2D(4, 5), // Lower Right Corner + down
                new Point2D(1, 5), // Lower Left Corner + down
                new Point2D(0, 1), // Upper Left Corner + left
                new Point2D(5, 1), // Upper Right Corner + right
                new Point2D(5, 4), // Lower Right Corner + right
                new Point2D(0, 4)  // Lower Left Corner + left
        };

        for (Point2D point : points) {
            assertThat(area.containsExternal(point)).isFalse();
        }
    }

    @Test
    void containsInternal() {
        Point2D[] points = {
                new Point2D(2, 2), // Upper Left Corner
                new Point2D(5, 2), // Upper Right Corner
                new Point2D(5, 2), // Lower Right Corner
                new Point2D(2, 5) // Lower Left Corner
        };

        for (Point2D point : points) {
            assertThat(area.containsInternal(point)).isTrue();
        }
    }

    @Test
    void doesntContainInternal() {
        Point2D[] points = {
                new Point2D(1, 1), // Upper Left Corner + up, left
                new Point2D(6, 1), // Upper Right Corner + up, right
                new Point2D(6, 6), // Lower Right Corner + down, right
                new Point2D(1, 6), // Lower Left Corner + down, left
                new Point2D(2, 1), // Upper Left Corner + up
                new Point2D(5, 1), // Upper Right Corner + up
                new Point2D(5, 6), // Lower Right Corner + down
                new Point2D(2, 6), // Lower Left Corner + down
                new Point2D(1, 2), // Upper Left Corner + left
                new Point2D(6, 2), // Upper Right Corner + right
                new Point2D(6, 5), // Lower Right Corner + right
                new Point2D(1, 5)  // Lower Left Corner + left
        };

        for (Point2D point : points) {
            assertThat(area.containsInternal(point)).isFalse();
        }
    }

    @Test
    void streamInternal() {
        Point2D[] points = new Point2D[16];

        int i = 0;
        for (int x = 2; x <= 5; x++) {
            for (int y = 2; y <= 5; y++) {
                points[i] = new Point2D(x, y);
                i++;
            }
        }

        assertThat(area.streamInternal().collect(Collectors.toSet())).isEqualTo(Sets.newSet(points));
    }

    @Test
    void streamExternal() {
        Point2D[] points = new Point2D[16];

        int i = 0;
        for (int x = 1; x <= 4; x++) {
            for (int y = 1; y <= 4; y++) {
                points[i] = new Point2D(x, y);
                i++;
            }
        }

        assertThat(area.streamExternal().collect(Collectors.toSet())).isEqualTo(Sets.newSet(points));
    }

    @Test
    void streamExternalCorners() {
        Point2D[] points = {
                new Point2D(1, 1), // Upper Left Corner
                new Point2D(4, 1), // Upper Right Corner
                new Point2D(4, 4), // Lower Right Corner
                new Point2D(1, 4) // Lower Left Corner
        };

        assertThat(area.streamExternalCorners().collect(Collectors.toSet())).isEqualTo(Sets.newSet(points));
    }

    @Test
    void streamInternalCorners() {
        Point2D[] points = {
                new Point2D(2, 2), // Upper Left Corner
                new Point2D(5, 2), // Upper Right Corner
                new Point2D(5, 5), // Lower Right Corner
                new Point2D(2, 5) // Lower Left Corner
        };

        assertThat(area.streamInternalCorners().collect(Collectors.toSet())).isEqualTo(Sets.newSet(points));
    }
}