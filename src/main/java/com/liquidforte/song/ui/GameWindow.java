package com.liquidforte.song.ui;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow(UIContainer container) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        add(new JLabel(new ImageIcon(container.getContainer())));
    }

    public void start() {
        SwingUtilities.invokeLater(() -> {
            pack();
            setVisible(true);
        });
    }
}
