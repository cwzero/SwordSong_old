package com.liquidforte.song.pointer;

public interface Destination<K, V> {
    default V set(K k, V v) {
        return putValue(k, v);
    }

    default V setValue(K k, V v) {
        return putValue(k, v);
    }

    V putValue(K k, V v);

    default V removeKey(K k) {
        return putValue(k, null);
    }

    DestinationPointer<K, V> getDestinationPointer(K k);
}
