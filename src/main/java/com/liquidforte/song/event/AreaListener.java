package com.liquidforte.song.event;

public abstract class AreaListener implements GridUpdateListener {
    private final int x, y;
    private final int width, height;

    public AreaListener(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean contains(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    @Override
    public boolean filter(GridUpdateEvent event) {
        return contains(event.x - this.x, event.y - this.y);
    }
}
