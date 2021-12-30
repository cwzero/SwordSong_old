package com.liquidforte.song.pointer;

import java.util.function.Supplier;

public interface SourcePointer<K, V> extends Supplier<V>, Pointer<K, V> {
    V getValue();

    @Override
    default V get() {
        return getValue();
    }
}
