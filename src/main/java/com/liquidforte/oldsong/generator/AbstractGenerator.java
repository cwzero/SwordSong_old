package com.liquidforte.oldsong.generator;

import com.liquidforte.oldsong.event.GeneratorEvent;
import com.liquidforte.oldsong.event.GeneratorListener;
import com.liquidforte.oldsong.event.AbstractEventSource;

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
