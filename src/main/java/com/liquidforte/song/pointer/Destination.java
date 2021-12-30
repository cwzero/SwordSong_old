package com.liquidforte.song.pointer;

public interface Destination<K, V> {
    V set(K k, V v);

    V setValue(K k, V v);

    V removeKey(K k);

    DestinationPointer<K, V> getDestinationPointer(K k);
}
