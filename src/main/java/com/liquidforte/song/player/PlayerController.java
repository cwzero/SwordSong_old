package com.liquidforte.song.player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerController extends KeyAdapter {
    private final Player player;
    private final Runnable updateFn;

    public PlayerController(Player player, Runnable updateFn) {
        this.player = player;
        this.updateFn = updateFn;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (KeyEvent.getKeyText(e.getKeyCode()).trim().toLowerCase()) {
            case "a" -> player.moveWest();
            case "d" -> player.moveEast();
            case "w" -> player.moveNorth();
            case "s" -> player.moveSouth();
            case "." -> player.moveUp();
            case "," -> player.moveDown();
        }
        updateFn.run();
    }
}
