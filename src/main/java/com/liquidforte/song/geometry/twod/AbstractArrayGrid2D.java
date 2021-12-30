package com.liquidforte.song.geometry.twod;

public abstract class AbstractArrayGrid2D<G extends Grid2D<G, V>, V> extends AbstractGrid2D<G, V> {
    private final V[][] grid;

    public AbstractArrayGrid2D(int width, int height, Array2DCreator<V> creator) {
        this(creator.create(width, height));
    }

    public AbstractArrayGrid2D(Size2D size, Array2DCreator<V> creator) {
        this(creator.create(size));
    }

    public AbstractArrayGrid2D(V[][] grid) {
        this.grid = grid;
    }

    @Override
    public int getWidth() {
        return grid.length;
    }

    @Override
    public int getHeight() {
        return grid[0].length;
    }

    @Override
    protected V doGet(int x, int y) {
        return grid[x][y];
    }

    @Override
    protected V doPut(int x, int y, V v) {
        V old = grid[x][y];
        grid[x][y] = v;
        return old;
    }
}
