package com.liquidforte.song.ui;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow(GridPanel gridPanel) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        add(gridPanel);
        addKeyListener(gridPanel.getGrid());
    }

    public void start() {
        SwingUtilities.invokeLater(() -> {
            pack();
            setVisible(true);
        });
    }
}
