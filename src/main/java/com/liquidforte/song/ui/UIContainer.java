package com.liquidforte.song.ui;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIContainer {
    private final int width, height;
    private final BufferedImage container;
    private final Graphics2D graphics;

    public UIContainer(int width, int height) {
        this.container = new BufferedImage(width * 16, height * 16, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = container.createGraphics();
        graphics.setBackground(Color.black);
        graphics.clearRect(0, 0, width * 16, height * 16);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Graphics2D getGraphics() {
        return graphics;
    }

    public BufferedImage getContainer() {
        return container;
    }
}
