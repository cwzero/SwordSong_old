package com.liquidforte.song.pointer;

public interface Destination<K, V> {
    V setValue(K k, V v);

    default DestinationPointer<K, V> getDestinationPointer(K k) {
        return new DestinationPointer<>() {
            @Override
            public V setValue(V v) {
                return Destination.this.setValue(k, v);
            }

            @Override
            public K getKey() {
                return k;
            }
        };
    }
}
