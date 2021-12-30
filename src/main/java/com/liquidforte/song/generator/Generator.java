package com.liquidforte.song.generator;

import com.liquidforte.song.event.EventSource;
import com.liquidforte.song.event.GeneratorEvent;
import com.liquidforte.song.event.GeneratorListener;
import com.liquidforte.song.space.LayeredSpaceGrid;

public interface Generator extends EventSource {
    void addGeneratorListener(GeneratorListener listener);

    void removeGeneratorListener(GeneratorListener listener);
}
