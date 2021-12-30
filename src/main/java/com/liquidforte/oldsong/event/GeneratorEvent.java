package com.liquidforte.oldsong.event;

import com.liquidforte.oldsong.generator.Generator;

public interface GeneratorEvent {
    Generator getSource();
}
