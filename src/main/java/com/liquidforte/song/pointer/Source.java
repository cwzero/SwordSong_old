package com.liquidforte.song.pointer;

public interface Source<K, V> {
    V getValue(K k);

    SourcePointer<K, V> getSourcePointer(K k);
}
