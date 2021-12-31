package com.liquidforte.song.pointer;

public interface SourcePointer<K, V> extends Pointer<K, V> {
    V getValue();
}
