package com.liquidforte.song.ui;

import com.liquidforte.song.grid.ArrayTileGrid;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
    private final ArrayTileGrid grid;

    public GridPanel(int width, int height) {
        this(new ArrayTileGrid(width, height));
    }

    public GridPanel(ArrayTileGrid grid) {
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
