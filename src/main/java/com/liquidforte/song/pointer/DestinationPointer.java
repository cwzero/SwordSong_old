package com.liquidforte.song.pointer;

import java.util.function.Function;

public interface DestinationPointer<K, V> extends Function<V, V>, Pointer<K, V> {

}
