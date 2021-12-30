package com.liquidforte.oldsong.ui;

import com.liquidforte.oldsong.grid.ArrayTileGrid;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final ArrayTileGrid grid;

    public GamePanel(int width, int height) {
        this(new ArrayTileGrid(width, height));
    }

    public GamePanel(ArrayTileGrid grid) {
        this.grid = grid;

        setPreferredSize(new Dimension(grid.getWidth() * 16, grid.getHeight() * 16));
        grid.addListener(event -> repaint());
        addKeyListener(grid);
    }

    public ArrayTileGrid getGrid() {
        return grid;
    }

    @Override
    public void paint(Graphics g) {
        grid.draw((Graphics2D) g, 0, 0);
    }
}
