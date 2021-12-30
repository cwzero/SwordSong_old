package com.liquidforte.song.math.geometry;

@SuppressWarnings("unchecked")
public interface Point<P extends Point<P>> extends Vector<P>, Located<P> {
    @Override
    default P getLocation() {
        return (P) this;
    }
}
