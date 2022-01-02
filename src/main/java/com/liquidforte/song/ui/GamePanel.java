package com.liquidforte.song.ui;

import com.liquidforte.song.world.GameWorld;
import com.liquidforte.song.world.GameWorldLayer;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final GameWorld world;
    private int z;

    public GamePanel(GameWorld world) {
        this.world = world;
    }

    public GameWorldLayer getLayer() {
        return world.getLayer(z);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getLayer().getWidth() * 16, getLayer().getHeight() * 16);
    }

    @Override
    public void paint(Graphics g) {
        var graphics = (Graphics2D) g;
        graphics.setBackground(Color.black);
        graphics.clearRect(0, 0, getWidth(), getHeight());
    }
}
