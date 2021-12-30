package com.liquidforte.song.test.geometry.threed;

import com.liquidforte.song.geometry.threed.Area3D;
import com.liquidforte.song.geometry.threed.Point3D;
import com.liquidforte.song.geometry.threed.Size3D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Area3DTest {
    private Area3D area;

    @BeforeEach
    void setUp() {
        Point3D externalOffset = new Point3D(1, 1, 1);
        Point3D internalOffset = new Point3D(2, 2, 2);
        Size3D size = new Size3D(3, 3, 3);
        area = new Area3D(externalOffset, internalOffset, size);
    }

    @Test
    void transformEnter() {
        Point3D external = new Point3D(1, 1, 1);
        Point3D internal = new Point3D(2, 2, 2);
        assertThat(area.transformEnter(external)).isEqualTo(internal);
    }

    @Test
    void transformExit() {
        Point3D external = new Point3D(1, 1, 1);
        Point3D internal = new Point3D(2, 2, 2);
        assertThat(area.transformExit(internal)).isEqualTo(external);
    }

    @Test
    void containsExternal() {
        Point3D[] points = {
                new Point3D(1, 1, 1), // Upper Left Top Corner
                new Point3D(4, 1, 1), // Upper Right Top Corner
                new Point3D(4, 4, 1), // Lower Right Top Corner
                new Point3D(1, 4, 1), // Lower Left Top Corner
                new Point3D(1, 1, 4), // Upper Left Bottom Corner
                new Point3D(4, 1, 4), // Upper Right Bottom Corner
                new Point3D(4, 4, 4), // Lower Right Bottom Corner
                new Point3D(1, 4, 4) // Lower Left Bottom Corner
        };

        for (Point3D point : points) {
            assertThat(area.containsExternal(point)).isTrue();
        }
    }

    void testCorners(Supplier<Stream<Point3D>> cornerSupplier, Predicate<Point3D> test,
                     Function<Integer, Integer> mapX, Function<Integer, Integer> mapY, Function<Integer, Integer> mapZ) {
        Function<Point3D, Point3D> pMapX = p -> new Point3D(mapX.apply(p.x()), p.y(), p.z());
        Function<Point3D, Point3D> pMapY = p -> new Point3D(p.x(), mapY.apply(p.y()), p.z());
        Function<Point3D, Point3D> pMapZ = p -> new Point3D(p.x(), p.y(), mapZ.apply(p.z()));


        cornerSupplier.get().map(pMapX)
                .forEach(p -> assertThat(test.test(p)).isFalse());
        cornerSupplier.get().map(pMapY)
                .forEach(p -> assertThat(test.test(p)).isFalse());
        cornerSupplier.get().map(pMapZ)
                .forEach(p -> assertThat(test.test(p)).isFalse());

        cornerSupplier.get().map(pMapX.andThen(pMapY))
                .forEach(p -> assertThat(test.test(p)).isFalse());
        cornerSupplier.get().map(pMapY.andThen(pMapZ))
                .forEach(p -> assertThat(test.test(p)).isFalse());
        cornerSupplier.get().map(pMapZ.andThen(pMapX))
                .forEach(p -> assertThat(test.test(p)).isFalse());

        cornerSupplier.get().map(pMapX.andThen(pMapY).andThen(pMapZ))
                .forEach(p -> assertThat(test.test(p)).isFalse());

    }

    @Test
    void doesntContainExternal() {
        Function<Integer, Integer> mapX = x -> {
            if (x == area.externalOffset().x()) {
                return x - 1;
            } else {
                return x + 1;
            }
        };
        Function<Integer, Integer> mapY = y -> {
            if (y == area.externalOffset().y()) {
                return y - 1;
            } else {
                return y + 1;
            }
        };
        Function<Integer, Integer> mapZ = z -> {
            if (z == area.externalOffset().z()) {
                return z - 1;
            } else {
                return z + 1;
            }
        };

        testCorners(area::streamExternalCorners, area::containsExternal, mapX, mapY, mapZ);
    }

    @Test
    void containsInternal() {
        Point3D[] points = {
                new Point3D(2, 2, 2), // Upper Left Top Corner
                new Point3D(5, 2, 2), // Upper Right Top Corner
                new Point3D(5, 5, 2), // Lower Right Top Corner
                new Point3D(2, 5, 2), // Lower Left Top Corner,
                new Point3D(2, 2, 5), // Upper Left Bottom Corner
                new Point3D(5, 2, 5), // Upper Right Bottom Corner
                new Point3D(5, 5, 5), // Lower Right Bottom Corner
                new Point3D(2, 5, 5) // Lower Left Bottom Corner
        };

        for (Point3D point : points) {
            assertThat(area.containsInternal(point)).isTrue();
        }
    }

    @Test
    void doesntContainInternal() {
        Function<Integer, Integer> mapX = x -> {
            if (x == area.internalOffset().x()) {
                return x - 1;
            } else {
                return x + 1;
            }
        };
        Function<Integer, Integer> mapY = y -> {
            if (y == area.internalOffset().y()) {
                return y - 1;
            } else {
                return y + 1;
            }
        };
        Function<Integer, Integer> mapZ = z -> {
            if (z == area.internalOffset().z()) {
                return z - 1;
            } else {
                return z + 1;
            }
        };

        testCorners(area::streamInternalCorners, area::containsInternal, mapX, mapY, mapZ);
    }

    @Test
    void streamInternal() {
        Point3D[] points = new Point3D[64];

        int i = 0;
        for (int x = 2; x <= 5; x++) {
            for (int y = 2; y <= 5; y++) {
                for (int z = 2; z <= 5; z++) {
                    points[i] = new Point3D(x, y, z);
                    i++;
                }
            }
        }

        assertThat(area.streamInternal().collect(Collectors.toSet())).isEqualTo(Set.of(points));
    }

    @Test
    void streamExternal() {
        Point3D[] points = new Point3D[64];

        int i = 0;
        for (int x = 1; x <= 4; x++) {
            for (int y = 1; y <= 4; y++) {
                for (int z = 1; z <= 4; z++) {
                    points[i] = new Point3D(x, y, z);
                    i++;
                }
            }
        }

        assertThat(area.streamExternal().collect(Collectors.toSet())).isEqualTo(Set.of(points));
    }

    @Test
    void streamInternalCorners() {
        Point3D[] points = {
                new Point3D(2, 2, 2), // Upper Left Top Corner
                new Point3D(5, 2, 2), // Upper Right Top Corner
                new Point3D(5, 5, 2), // Lower Right Top Corner
                new Point3D(2, 5, 2), // Lower Left Top Corner,
                new Point3D(2, 2, 5), // Upper Left Bottom Corner
                new Point3D(5, 2, 5), // Upper Right Bottom Corner
                new Point3D(5, 5, 5), // Lower Right Bottom Corner
                new Point3D(2, 5, 5) // Lower Left Bottom Corner
        };

        assertThat(area.streamInternalCorners().collect(Collectors.toSet())).isEqualTo(Set.of(points));
    }

    @Test
    void streamExternalCorners() {
        Point3D[] points = {
                new Point3D(1, 1, 1), // Upper Left Top Corner
                new Point3D(4, 1, 1), // Upper Right Top Corner
                new Point3D(4, 4, 1), // Lower Right Top Corner
                new Point3D(1, 4, 1), // Lower Left Top Corner
                new Point3D(1, 1, 4), // Upper Left Bottom Corner
                new Point3D(4, 1, 4), // Upper Right Bottom Corner
                new Point3D(4, 4, 4), // Lower Right Bottom Corner
                new Point3D(1, 4, 4) // Lower Left Bottom Corner
        };

        assertThat(area.streamExternalCorners().collect(Collectors.toSet())).isEqualTo(Set.of(points));
    }
}