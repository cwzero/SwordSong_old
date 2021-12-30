package com.liquidforte.song.entity;

import com.liquidforte.song.block.Block;
import com.liquidforte.song.space.LayeredSpaceGrid;
import com.liquidforte.song.space.Space;
import com.liquidforte.song.tile.Tile;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class TileMovement extends AbstractMovement {
    private final Tile tile;
    private final Layer layer;
    private final boolean solid;

    public TileMovement(LayeredSpaceGrid world, Block tile) {
        this(world, tile, Layer.Foreground);
    }

    public TileMovement(LayeredSpaceGrid world, Block tile, Layer layer) {
        this(world, tile, layer, tile.isSolid());
    }

    public TileMovement(LayeredSpaceGrid world, Tile tile) {
        this(world, tile, Layer.Foreground);
    }

    public TileMovement(LayeredSpaceGrid world, Tile tile, Layer layer) {
        this(world, tile, layer, true);
    }

    public TileMovement(LayeredSpaceGrid world, Tile tile, Layer layer, boolean solid) {
        super(world);
        this.tile = tile;
        this.layer = layer;
        this.solid = solid;
    }

    public Function<Space, Tile> getLayerMapping() {
        return switch (layer) {
            case Foreground -> Space::getForeground;
            case Background -> Space::getBackground;
        };
    }

    public BiConsumer<Space, Tile> setLayerMapping() {
        return switch (layer) {
            case Foreground -> Space::setForeground;
            case Background -> Space::setBackground;
        };
    }

    public Consumer<Space> clearLayerMapping() {
        return switch (layer) {
            case Foreground -> Space::clearForeground;
            case Background -> Space::clearBackground;
        };
    }

    @Override
    public boolean isSourceValid(Space source) {
        Tile tile = getLayerMapping().apply(source);
        return tile != null && tile.equals(this.tile);
    }

    @Override
    public boolean isDestValid(Space dest) {
        return !solid || !isDestSolid();
    }

    @Override
    public boolean remove(Space source) {
        clearLayerMapping().accept(source);
        return true;
    }

    @Override
    public boolean place(Space dest) {
        setLayerMapping().accept(dest, tile);
        return true;
    }
}
