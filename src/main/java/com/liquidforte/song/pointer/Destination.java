package com.liquidforte.song.pointer;

public interface Destination<K, V> {
    V set(K k, V v);

    DestinationPointer<K, V> getDestinationPointer(K k);
}
