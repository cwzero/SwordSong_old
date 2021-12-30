package com.liquidforte.song.math.geometry;

import java.util.Set;
import java.util.stream.Stream;

public interface Size<P extends Point> extends Vector {
    Set<P> getPointSet();

    Stream<P> getPointStream();
}
