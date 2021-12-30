package com.liquidforte.song.entity;

import com.liquidforte.song.space.Space;

public interface Positional {
    int getX();

    int getY();

    int getZ();

    Space getSpace();
}
