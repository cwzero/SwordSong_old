package com.liquidforte.song.geometry;

public abstract class AbstractArrayGrid3D<G extends Grid3D<G, V>, V> extends AbstractGrid3D<G, V> {
    private final V[][][] grid;

    public AbstractArrayGrid3D(int width, int height, int depth, Array3DCreator<V> creator) {
        this(creator.create(width, height, depth));
    }

    public AbstractArrayGrid3D(Size3D size, Array3DCreator<V> creator) {
        this(creator.create(size));
    }

    public AbstractArrayGrid3D(V[][][] grid) {
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
    public int getDepth() {
        return grid[0][0].length;
    }

    @Override
    protected V doGet(int x, int y, int z) {
        return grid[x][y][z];
    }

    @Override
    protected V doPut(int x, int y, int z, V v) {
        V current = grid[x][y][z];
        grid[x][y][z] = v;
        return current;
    }
}
