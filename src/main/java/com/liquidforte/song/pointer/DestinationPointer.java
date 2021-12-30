package com.liquidforte.song.pointer;

import java.util.function.Function;

public interface DestinationPointer<K, V> extends Function<V, V>, Pointer<K, V> {
    V setValue(V v);

    @Override
    default V apply(V v) {
        return setValue(v);
    }
}
