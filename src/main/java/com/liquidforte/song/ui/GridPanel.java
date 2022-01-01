package com.liquidforte.song.ui;

import com.liquidforte.song.math.geometry.two.Size2D;
import com.liquidforte.song.tilegrid.two.TileGrid2D;
import com.liquidforte.song.util.DrawingUtil;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
    private final TileGrid2D grid;
    private final Size2D size;

    public GridPanel(TileGrid2D grid, Size2D size) {
        this.grid = grid;
        this.size = size;
        grid.addListener(event -> repaint());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size.width() * 16, size.height() * 16);
    }

    @Override
    public void paint(Graphics g) {
        var graphics = (Graphics2D) g;
        graphics.setBackground(Color.black);
        graphics.clearRect(0, 0, size.width() * 16, size.height() * 16);
        DrawingUtil.drawGrid(grid, graphics, 0, 0, size.width(), size.height());
    }
}
