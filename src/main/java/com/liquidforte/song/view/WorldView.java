package com.liquidforte.song.view;

import com.liquidforte.song.world.GameWorld;

public interface WorldView extends GridView {
    GameWorld getWorld();
}
