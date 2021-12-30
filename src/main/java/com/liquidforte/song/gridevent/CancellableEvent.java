package com.liquidforte.song.gridevent;

public class CancellableEvent {
    private boolean cancelled = false;

    public boolean isCancelled() {
        return cancelled;
    }

    public boolean setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
        return true;
    }

    public boolean cancel() {
        return this.cancelled = true;
    }
}
