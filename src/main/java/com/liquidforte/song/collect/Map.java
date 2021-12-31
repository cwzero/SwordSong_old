package com.liquidforte.song.collect;

import com.liquidforte.song.pointer.Destination;
import com.liquidforte.song.pointer.Source;

// TODO: super interfaces?
public interface Map<K, V> extends Source<K, V>, Destination<K, V> {
    default MapPointer<K, V> getMapPointer(K key) {
        return new MapPointer<>() {
            @Override
            public V setValue(V v) {
                return Map.this.setValue(key, v);
            }

            @Override
            public V getValue() {
                return Map.this.getValue(key);
            }

            @Override
            public K getKey() {
                return key;
            }
        };
    }
}
