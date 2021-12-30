package com.liquidforte.oldsong.player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerController extends KeyAdapter {
    private final Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (KeyEvent.getKeyText(e.getKeyCode()).toLowerCase()) {
            case "w" -> player.moveNorth();
            case "d" -> player.moveEast();
            case "s" -> player.moveSouth();
            case "a" -> player.moveWest();
        }
    }
}
