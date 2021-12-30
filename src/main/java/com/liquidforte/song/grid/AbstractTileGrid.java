package com.liquidforte.song.grid;

import com.liquidforte.song.block.Block;
import com.liquidforte.song.event.*;
import com.liquidforte.song.space.Space;
import com.liquidforte.song.space.SpaceGrid;
import com.liquidforte.song.tile.ListenTile;
import com.liquidforte.song.tile.Tile;
import com.liquidforte.song.util.TileUtil;

import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTileGrid extends KeyAdapter implements TileGrid {
    private final EventListenerList listeners = new EventListenerList();
    private Map<ListenTile, TileUpdateListener> tileListeners = new HashMap<>();

    public boolean contains(int x, int y) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
    }

    protected abstract Tile doGetTile(int x, int y);

    protected abstract Tile doSetTile(Tile tile, int x, int y);

    public boolean isSolid(int x, int y) {
        return !(getTile(x, y) instanceof Block b && !b.isSolid());
    }

    @Override
    public Tile getTile(int x, int y) {
        if (contains(x, y)) {
            return doGetTile(x, y);
        }
        return null;
    }

    @Override
    public void addListener(GridUpdateListener listener) {
        listeners.add(GridUpdateListener.class, listener);
    }

    @Override
    public void addKeyListener(KeyListener keyListener) {
        listeners.add(KeyListener.class, keyListener);
    }

    @Override
    public Tile setTile(Tile tile, int x, int y) {
        if (contains(x, y)) {
            Tile oldTile = getTile(x, y);

            if (TileUtil.checkDirty(oldTile, tile)) {
                if (oldTile instanceof ListenTile t) {
                    t.removeUpdateListener(tileListeners.get(oldTile));
                }

                doSetTile(tile, x, y);

                if (tile instanceof ListenTile l) {
                    tileListeners.put(l, event -> fireUpdate(event.oldTile, event.newTile, x, y));
                    l.addUpdateListener(tileListeners.get(tile));
                }

                fireUpdate(oldTile, tile, x, y);

                return tile;
            }
        }

        return null;
    }

    public void fireUpdate() {
        fireUpdate(new GridUpdateEvent(this));
    }

    protected void fireUpdate(Tile oldTile, Tile newTile, int x, int y) {
        fireUpdate(new GridTileUpdateEvent(this, oldTile, newTile, x, y));
    }

    protected void fireUpdate(Tile oldTile, Tile newTile, Point pos) {
        fireUpdate(new GridTileUpdateEvent(this, oldTile, newTile, pos.x, pos.y));
    }

    protected void fireUpdate(GridUpdateEvent event) {
        Arrays.stream(listeners.getListeners(GridUpdateListener.class))
                .filter(it -> it.filter(event))
                .forEach(it -> it.gridUpdate(event));
    }

    @Override
    public TileGridView createSubGrid(int x, int y, int width, int height) {
        return new SubGrid(this, x, y, width, height);
    }

    @Override
    public TileGridView createOffsetGrid(int x, int y) {
        return new OffsetTileGrid(this, x, y);
    }

    /* TODO: a way to swap overlays - a gridaccess that swaps which grid we're looking at
     *      this requires a dynamic grid view - a movable subgrid, as well as a listener that
     *      listens for changes in the actual viewed area (depending on movement)
     */
    @Override
    public void addOverlay(GridDrawing source, int yourOffsetX, int yourOffsetY, int myOffsetX, int myOffsetY, int width, int height) {
        source.addListener(new AreaListener(yourOffsetX, yourOffsetY, width, height) {
            @Override
            public void gridUpdate(GridUpdateEvent event) {
                source.drawArea(AbstractTileGrid.this, myOffsetX, myOffsetY, yourOffsetX, yourOffsetY, width, height);
            }
        });
    }

    @Override
    public void drawArea(Graphics2D graphics, int yourOffsetX, int yourOffsetY, int myOffsetX, int myOffsetY, int width, int height) {
        graphics.setBackground(Color.black);
        graphics.clearRect(yourOffsetX, yourOffsetY, width * 16, height * 16);
        int runWidth = Math.min(width, getWidth() - myOffsetX);
        int runHeight = Math.min(height, getHeight() - myOffsetY);

        for (int x = 0; x < runWidth; x++) {
            for (int y = 0; y < runHeight; y++) {
                Tile source = getTile(x + myOffsetX, y + myOffsetY);
                if (source != null) {
                    graphics.drawImage(source.getTexture(), x * 16 + yourOffsetX, y * 16 + yourOffsetY, null);
                }
            }
        }
    }

    @Override
    public void drawArea(SpaceGrid grid, int yourOffsetX, int yourOffsetY, int myOffsetX, int myOffsetY, int width, int height) {
        int myWidth = getWidth() - myOffsetX;
        int myHeight = getHeight() - myOffsetY;

        int yourWidth = grid.getWidth() - yourOffsetX;
        int yourHeight = grid.getHeight() - yourOffsetY;

        int runWidth = Math.min(myWidth, yourWidth);
        int runHeight = Math.min(myHeight, yourHeight);

        for (int x = 0; x < runWidth; x++) {
            for (int y = 0; y < runHeight; y++) {
                Tile source = getTile(x + myOffsetX, y + myOffsetY);
                if (source != null) {
                    if (source instanceof Space) {
                        grid.setTile(source, x + yourOffsetX, y + yourOffsetY);
                    } else {
                        Space space = grid.createSpace(x + yourOffsetX, y + yourOffsetY);
                        space.setBackground(source);
                    }
                }
            }
        }
    }

    @Override
    public void drawArea(TileGridAccess grid, int yourOffsetX, int yourOffsetY, int myOffsetX, int myOffsetY, int width, int height) {
        int myWidth = getWidth() - myOffsetX;
        int myHeight = getHeight() - myOffsetY;

        int yourWidth = grid.getWidth() - yourOffsetX;
        int yourHeight = grid.getHeight() - yourOffsetY;

        int runWidth = Math.min(myWidth, yourWidth);
        int runHeight = Math.min(myHeight, yourHeight);

        for (int x = 0; x < runWidth; x++) {
            for (int y = 0; y < runHeight; y++) {
                Tile source = getTile(x + myOffsetX, y + myOffsetY);
                if (source != null) {
                    grid.setTile(source, x + yourOffsetX, y + yourOffsetY);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Arrays.stream(listeners.getListeners(KeyListener.class)).forEach(it -> it.keyTyped(e));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Arrays.stream(listeners.getListeners(KeyListener.class)).forEach(it -> it.keyPressed(e));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Arrays.stream(listeners.getListeners(KeyListener.class)).forEach(it -> it.keyReleased(e));
    }
}
