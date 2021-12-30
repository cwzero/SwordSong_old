package com.liquidforte.song.generator;

import com.liquidforte.song.event.AbstractEventSource;
import com.liquidforte.song.event.GeneratorEvent;
import com.liquidforte.song.event.GeneratorListener;

public abstract class AbstractGenerator extends AbstractEventSource implements Generator {
    protected void fireEvent(GeneratorEvent event) {
        fireEvent(GeneratorListener.class, GeneratorListener::filter, GeneratorListener::handle, event);
    }

    @Override
    public void addGeneratorListener(GeneratorListener listener) {
        addListener(GeneratorListener.class, listener);
    }

    @Override
    public void removeGeneratorListener(GeneratorListener listener) {
        removeListener(GeneratorListener.class, listener);
    }
}
