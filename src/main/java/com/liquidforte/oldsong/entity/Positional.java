package com.liquidforte.oldsong.entity;

import com.liquidforte.oldsong.space.Space;

public interface Positional {
    int getX();

    int getY();

    int getZ();

    Space getSpace();
}
