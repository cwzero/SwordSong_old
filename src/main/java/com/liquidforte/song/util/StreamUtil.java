package com.liquidforte.song.util;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamUtil {
    public static <T, R> Stream<R> mapAndFilter(Stream<T> stream, Function<T, R> mapFn, Predicate<R> filter) {
        return stream.map(mapFn).filter(filter);
    }

    public static <T, R> Stream<R> mapNonNull(Stream<T> stream, Function<T, R> mapFn) {
        return stream.map(mapFn).filter(Objects::nonNull);
    }
}
