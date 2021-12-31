package com.liquidforte.song.pointer;

public interface Source<K, V> {
    V getValue(K k);

    default SourcePointer<K, V> getSourcePointer(K k) {
        return new SourcePointer<>() {
            @Override
            public V getValue() {
                return Source.this.getValue(k);
            }

            @Override
            public K getKey() {
                return k;
            }
        };
    }
}
