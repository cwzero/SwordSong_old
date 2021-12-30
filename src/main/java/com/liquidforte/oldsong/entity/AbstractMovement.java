package com.liquidforte.oldsong.entity;

import com.liquidforte.oldsong.event.AbstractEventSource;
import com.liquidforte.oldsong.event.MovementEvent;
import com.liquidforte.oldsong.event.MovementListener;
import com.liquidforte.oldsong.space.LayeredSpaceGrid;
import com.liquidforte.oldsong.space.Space;

public abstract class AbstractMovement extends AbstractEventSource implements Movement {
    private final PositionPointer source;
    private final PositionPointer dest;

    public AbstractMovement(LayeredSpaceGrid world) {
        this(new PositionPointer(world), new PositionPointer(world));
    }

    public AbstractMovement(PositionPointer source, PositionPointer dest) {
        this.source = source;
        this.dest = dest;
    }

    @Override
    public PositionPointer getSource() {
        return source;
    }

    @Override
    public Space getSourceSpace() {
        return getSource().getSpace();
    }

    @Override
    public Space createSourceSpace() {
        return getSource().createSpace();
    }

    @Override
    public PositionPointer getDest() {
        return dest;
    }

    @Override
    public Space getDestSpace() {
        return getDest().getSpace();
    }

    @Override
    public Space createDestSpace() {
        return getDest().createSpace();
    }

    @Override
    public boolean isDestSolid() {
        return createDestSpace().isSolid();
    }

    @Override
    public boolean isSourceValid() {
        return isSourceValid(createSourceSpace());
    }

    @Override
    public boolean isDestValid() {
        return isDestValid(createDestSpace());
    }

    @Override
    public boolean remove() {
        if (isSourceValid()) {
            return remove(getSourceSpace());
        }
        return false;
    }

    @Override
    public boolean place() {
        if (isDestValid()) {
            return place(getDestSpace());
        }
        return false;
    }

    @Override
    public boolean reset() {
        return dest.resetTo(source);
    }

    @Override
    public boolean move() {
        if (canMove()) {
            if (remove()) {
                return place();
            }
        }
        return false;
    }

    @Override
    public boolean canMove() {
        return isSourceValid() && isDestValid() && !source.equals(dest);
    }

    @Override
    public void addMovementListener(MovementListener listener) {
        addListener(MovementListener.class, listener);
    }

    @Override
    public void removeMovementListener(MovementListener listener) {
        removeListener(MovementListener.class, listener);
    }

    @Override
    public void fireMovementEvent(MovementEvent event) {
        fireEvent(MovementListener.class,
                MovementListener::filterMove,
                MovementListener::handleMove,
                event);
    }
}
