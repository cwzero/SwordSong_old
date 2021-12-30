package com.liquidforte.song.pointer;

import java.util.Optional;

public interface Pointer<V> {
    V getValue();

    default Optional<V> findValue() {
        return Optional.ofNullable(getValue());
    }

    V setValue(V v);
}