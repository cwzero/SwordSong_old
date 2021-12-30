package com.liquidforte.oldsong.generator;

import com.liquidforte.oldsong.event.GeneratorListener;
import com.liquidforte.oldsong.event.EventSource;

public interface Generator extends EventSource {
    void addGeneratorListener(GeneratorListener listener);

    void removeGeneratorListener(GeneratorListener listener);
}
