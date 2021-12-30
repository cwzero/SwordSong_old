package com.liquidforte.oldsong.entity;

import com.liquidforte.oldsong.space.Space;
import com.liquidforte.oldsong.event.MovementEvent;
import com.liquidforte.oldsong.event.MovementListener;

public interface Movement {
    PositionPointer getSource();

    Space getSourceSpace();

    Space createSourceSpace();

    PositionPointer getDest();

    Space getDestSpace();

    Space createDestSpace();

    boolean isDestSolid();

    boolean isSourceValid();

    boolean isSourceValid(Space source);

    boolean isDestValid();

    boolean isDestValid(Space dest);

    boolean remove();

    boolean remove(Space source);

    boolean place();

    boolean place(Space dest);

    boolean reset();

    boolean move();

    boolean canMove();

    void addMovementListener(MovementListener listener);

    void removeMovementListener(MovementListener listener);

    void fireMovementEvent(MovementEvent event);
}
