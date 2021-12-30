package com.liquidforte.song.pointer;

public interface Source<K, V> {
    V get(Object key);

    SourcePointer<K, V> getSourcePointer(K k);
}
