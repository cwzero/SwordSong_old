package com.liquidforte.song.pointer;

public interface DestinationPointer<K, V> extends Pointer<K, V> {
    V setValue(V v);
}
