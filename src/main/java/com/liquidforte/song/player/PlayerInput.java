package com.liquidforte.song.player;

import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.world.GameWorld;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerInput extends KeyAdapter {
    private final GameWorld world;
    private final Player player;

    public PlayerInput(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (KeyEvent.getKeyText(e.getKeyCode()).trim().toLowerCase()) {
            case "w" -> player.place(world, new Point3D(player.getPos().x(), player.getPos().y() - 1, player.getPos().z()));
            case "s" -> player.place(world, new Point3D(player.getPos().x(), player.getPos().y() + 1, player.getPos().z()));
            case "a" -> player.place(world, new Point3D(player.getPos().x() - 1, player.getPos().y(), player.getPos().z()));
            case "d" -> player.place(world, new Point3D(player.getPos().x() + 1, player.getPos().y(), player.getPos().z()));
        }
    }
}
