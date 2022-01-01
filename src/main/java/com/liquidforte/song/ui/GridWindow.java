package com.liquidforte.song.ui;

import com.liquidforte.song.math.geometry.two.Size2D;
import com.liquidforte.song.tilegrid.two.TileGrid2D;

import javax.swing.*;

public class GridWindow extends JFrame {
    public GridWindow(TileGrid2D grid, Size2D size) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        add(new GridPanel(grid, size));
    }

    public void start() {
        SwingUtilities.invokeLater(() -> {
            pack();
            setVisible(true);
        });
    }
}
