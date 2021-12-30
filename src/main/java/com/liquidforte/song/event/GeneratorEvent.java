package com.liquidforte.song.event;

import com.liquidforte.song.generator.Generator;

public interface GeneratorEvent {
    Generator getSource();
}
