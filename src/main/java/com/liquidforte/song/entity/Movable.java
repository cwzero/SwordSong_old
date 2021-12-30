package com.liquidforte.song.entity;

public interface Movable extends Positional {
    boolean moveTo(int x, int y, int z);

    default boolean moveNorth() {
        return moveTo(getX(), getY() - 1, getZ());
    }

    default boolean moveEast() {
        return moveTo(getX() + 1, getY(), getZ());
    }

    default boolean moveSouth() {
        return moveTo(getX(), getY() + 1, getZ());
    }

    default boolean moveWest() {
        return moveTo(getX() - 1, getY(), getZ());
    }

    default boolean moveUp() {
        return moveTo(getX(), getY(), getZ() - 1);
    }

    default boolean moveDown() {
        return moveTo(getX(), getY(), getZ() + 1);
    }
}
