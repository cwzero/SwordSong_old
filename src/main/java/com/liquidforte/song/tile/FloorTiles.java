package com.liquidforte.song.tile;

import com.liquidforte.song.util.Tileset;

import java.awt.*;

public class FloorTiles {
    public final Tile floorCornerNESmooth;
    public final Tile floorCornerSESmooth;
    public final Tile floorCornerSWSmooth;
    public final Tile floorCornerNWSmooth;

    public final Tile floorHalfNorthSmooth;
    public final Tile floorHalfEastSmooth;
    public final Tile floorHalfSouthSmooth;
    public final Tile floorHalfWestSmooth;

    public final Tile floorFullSmooth;
    public final Tile floorFullSparse;
    public final Tile floorFullMedium;
    public final Tile floorFullDense;

    public final Tile floorHalfNorthSparse;
    public final Tile floorHalfEastSparse;
    public final Tile floorHalfSouthSparse;
    public final Tile floorHalfWestSparse;

    public final Tile floorHalfNorthMedium;
    public final Tile floorHalfEastMedium;
    public final Tile floorHalfSouthMedium;
    public final Tile floorHalfWestMedium;

    public final Tile floorHalfNorthDense;
    public final Tile floorHalfEastDense;
    public final Tile floorHalfSouthDense;
    public final Tile floorHalfWestDense;

    public final Tile floorCornerNESparse;
    public final Tile floorCornerSESparse;
    public final Tile floorCornerSWSparse;
    public final Tile floorCornerNWSparse;

    public final Tile floorCornerNEMedium;
    public final Tile floorCornerSEMedium;
    public final Tile floorCornerSWMedium;
    public final Tile floorCornerNWMedium;

    public final Tile floorCornerNEDense;
    public final Tile floorCornerSEDense;
    public final Tile floorCornerSWDense;
    public final Tile floorCornerNWDense;

    public FloorTiles(Color floorColor, Color floorDecorationColor) {
        this(Color.black, floorColor, floorDecorationColor);
    }

    public FloorTiles(Color backgroundColor, Color floorColor, Color floorDecorationColor) {
        this.floorCornerSWSmooth = createTile(
                new ColoredTile(Tileset.HALF_BLOCK_TOP, backgroundColor),
                new ColoredTile(Tileset.HALF_BLOCK_LEFT, floorColor)
        );

        this.floorCornerNWSmooth = createTile(
                new ColoredTile(Tileset.HALF_BLOCK_BOTTOM, backgroundColor),
                new ColoredTile(Tileset.HALF_BLOCK_LEFT, floorColor)
        );

        this.floorCornerNESmooth = createTile(
                new ColoredTile(Tileset.HALF_BLOCK_BOTTOM, backgroundColor),
                new ColoredTile(Tileset.HALF_BLOCK_RIGHT, floorColor)
        );

        this.floorCornerSESmooth = createTile(
                new ColoredTile(Tileset.HALF_BLOCK_TOP, backgroundColor),
                new ColoredTile(Tileset.HALF_BLOCK_RIGHT, floorColor)
        );

        this.floorHalfNorthSmooth = new ColoredTile(Tileset.HALF_BLOCK_TOP, floorColor);
        this.floorHalfEastSmooth = new ColoredTile(Tileset.HALF_BLOCK_RIGHT, floorColor);
        this.floorHalfSouthSmooth = new ColoredTile(Tileset.HALF_BLOCK_BOTTOM, floorColor);
        this.floorHalfWestSmooth = new ColoredTile(Tileset.HALF_BLOCK_LEFT, floorColor);

        this.floorFullSmooth = new ColoredTile(Tileset.FULL_BLOCK, floorColor);
        this.floorFullSparse = createTile(new ColoredTile(Tileset.SPARSE_DOTS, floorDecorationColor), this.floorFullSmooth);
        this.floorFullMedium = createTile(new ColoredTile(Tileset.MEDIUM_DOTS, floorDecorationColor), this.floorFullSmooth);
        this.floorFullDense = createTile(new ColoredTile(Tileset.DENSE_DOTS, floorDecorationColor), this.floorFullSmooth);

        this.floorHalfNorthSparse = createTile(new ColoredTile(Tileset.HALF_BLOCK_BOTTOM, backgroundColor), this.floorFullSparse);
        this.floorHalfEastSparse = createTile(new ColoredTile(Tileset.HALF_BLOCK_LEFT, backgroundColor), this.floorFullSparse);
        this.floorHalfSouthSparse = createTile(new ColoredTile(Tileset.HALF_BLOCK_TOP, backgroundColor), this.floorFullSparse);
        this.floorHalfWestSparse = createTile(new ColoredTile(Tileset.HALF_BLOCK_RIGHT, backgroundColor), this.floorFullSparse);

        this.floorHalfNorthMedium = createTile(new ColoredTile(Tileset.HALF_BLOCK_BOTTOM, backgroundColor), this.floorFullMedium);
        this.floorHalfEastMedium = createTile(new ColoredTile(Tileset.HALF_BLOCK_LEFT, backgroundColor), this.floorFullMedium);
        this.floorHalfSouthMedium = createTile(new ColoredTile(Tileset.HALF_BLOCK_TOP, backgroundColor), this.floorFullMedium);
        this.floorHalfWestMedium = createTile(new ColoredTile(Tileset.HALF_BLOCK_RIGHT, backgroundColor), this.floorFullMedium);

        this.floorHalfNorthDense = createTile(new ColoredTile(Tileset.HALF_BLOCK_BOTTOM, backgroundColor), this.floorFullDense);
        this.floorHalfEastDense = createTile(new ColoredTile(Tileset.HALF_BLOCK_LEFT, backgroundColor), this.floorFullDense);
        this.floorHalfSouthDense = createTile(new ColoredTile(Tileset.HALF_BLOCK_TOP, backgroundColor), this.floorFullDense);
        this.floorHalfWestDense = createTile(new ColoredTile(Tileset.HALF_BLOCK_RIGHT, backgroundColor), this.floorFullDense);

        this.floorCornerNESparse = createTile(new ColoredTile(Tileset.HALF_BLOCK_BOTTOM, backgroundColor), this.floorHalfEastSparse);
        this.floorCornerSESparse = createTile(new ColoredTile(Tileset.HALF_BLOCK_TOP, backgroundColor), this.floorHalfEastSparse);
        this.floorCornerNWSparse = createTile(new ColoredTile(Tileset.HALF_BLOCK_BOTTOM, backgroundColor), this.floorHalfWestSparse);
        this.floorCornerSWSparse = createTile(new ColoredTile(Tileset.HALF_BLOCK_TOP, backgroundColor), this.floorHalfWestSparse);

        this.floorCornerNEMedium = createTile(new ColoredTile(Tileset.HALF_BLOCK_BOTTOM, backgroundColor), this.floorHalfEastMedium);
        this.floorCornerSEMedium = createTile(new ColoredTile(Tileset.HALF_BLOCK_TOP, backgroundColor), this.floorHalfEastMedium);
        this.floorCornerNWMedium = createTile(new ColoredTile(Tileset.HALF_BLOCK_BOTTOM, backgroundColor), this.floorHalfWestMedium);
        this.floorCornerSWMedium = createTile(new ColoredTile(Tileset.HALF_BLOCK_TOP, backgroundColor), this.floorHalfWestMedium);

        this.floorCornerNEDense = createTile(new ColoredTile(Tileset.HALF_BLOCK_BOTTOM, backgroundColor), this.floorHalfEastDense);
        this.floorCornerSEDense = createTile(new ColoredTile(Tileset.HALF_BLOCK_TOP, backgroundColor), this.floorHalfEastDense);
        this.floorCornerNWDense = createTile(new ColoredTile(Tileset.HALF_BLOCK_BOTTOM, backgroundColor), this.floorHalfWestDense);
        this.floorCornerSWDense = createTile(new ColoredTile(Tileset.HALF_BLOCK_TOP, backgroundColor), this.floorHalfWestDense);
    }

    private Tile createTile(Tile... layers) {
        return new LayeredTile(layers);
    }
}
