package com.liquidforte.song.grid;

import java.awt.*;

public interface GridDrawing extends TileGridAccess {
    default void draw(TileGridAccess grid, int yourOffsetX, int yourOffsetY) {
        drawArea(grid, yourOffsetX, yourOffsetY, 0, 0, getWidth(), getHeight());
    }

    default void draw(Graphics2D graphics, int yourOffsetX, int yourOffsetY) {
        drawArea(graphics, yourOffsetX, yourOffsetY, 0, 0, getWidth(), getHeight());
    }

    default void draw(Graphics2D graphics, Point yourOffset) {
        draw(graphics, yourOffset.x, yourOffset.y);
    }

    default void draw(Graphics graphics, int yourOffsetX, int yourOffsetY) {
        draw((Graphics2D) graphics, yourOffsetX, yourOffsetY);
    }

    void drawArea(Graphics2D graphics, int yourOffsetX, int yourOffsetY, int myOffsetX, int myOffsetY, int width, int height);

    default void drawArea(Graphics2D graphics, Point yourOffset, Point myOffset, Dimension size) {
        drawArea(graphics, yourOffset.x, yourOffset.y, myOffset.x, myOffset.y, size.width, size.height);
    }

    default void drawArea(Graphics graphics, int yourOffsetX, int yourOffsetY, int myOffsetX, int myOffsetY, int width, int height) {
        drawArea((Graphics2D) graphics, yourOffsetX, yourOffsetY, myOffsetX, myOffsetY, width, height);
    }

    default void drawArea(Graphics graphics, Point myOffset, Point yourOffset, Dimension size) {
        drawArea((Graphics2D) graphics, yourOffset, myOffset, size);
    }

    void drawArea(TileGridAccess grid, int yourOffsetX, int yourOffsetY, int myOffsetX, int myOffsetY, int width, int height);

    default void drawArea(TileGridAccess grid, Point myOffset, Point yourOffset, Dimension size) {
        drawArea(grid, yourOffset.x, yourOffset.y, myOffset.x, myOffset.y, size.width, size.height);
    }
}
