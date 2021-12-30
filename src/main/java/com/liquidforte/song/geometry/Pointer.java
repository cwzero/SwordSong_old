package com.liquidforte.song.geometry;

import java.util.Optional;

public interface Pointer<V> {
    V getValue();

    default Optional<V> findValue() {
        return Optional.ofNullable(getValue());
    }

    V setValue(V v);
}
