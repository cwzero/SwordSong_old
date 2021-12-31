package com.liquidforte.song.collect;

import com.liquidforte.song.pointer.DestinationPointer;
import com.liquidforte.song.pointer.SourcePointer;

public interface MapPointer<K, V> extends SourcePointer<K, V>, DestinationPointer<K, V> {

}
