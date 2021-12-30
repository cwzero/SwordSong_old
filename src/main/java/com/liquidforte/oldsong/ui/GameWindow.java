package com.liquidforte.oldsong.ui;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow(GamePanel gamePanel) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        add(gamePanel);
        addKeyListener(gamePanel.getGrid());
    }

    public void start() {
        SwingUtilities.invokeLater(() -> {
            pack();
            setVisible(true);
        });
    }
}
