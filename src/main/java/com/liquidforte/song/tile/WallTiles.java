package com.liquidforte.song.tile;

import com.liquidforte.song.util.Tileset;

import java.awt.*;

public class WallTiles extends FloorTiles {
    private final Color wallColor;

    public Tile wallCornerNESmooth;
    public Tile wallCornerSESmooth;
    public Tile wallCornerSWSmooth;
    public Tile wallCornerNWSmooth;

    public Tile wallCornerNESparse;
    public Tile wallCornerSESparse;
    public Tile wallCornerSWSparse;
    public Tile wallCornerNWSparse;

    public Tile wallCornerNEMedium;
    public Tile wallCornerSEMedium;
    public Tile wallCornerSWMedium;
    public Tile wallCornerNWMedium;

    public Tile wallCornerNEDense;
    public Tile wallCornerSEDense;
    public Tile wallCornerSWDense;
    public Tile wallCornerNWDense;

    public Tile wallHalfNorthSmooth;
    public Tile wallHalfEastSmooth;
    public Tile wallHalfSouthSmooth;
    public Tile wallHalfWestSmooth;

    public Tile wallHalfNorthSparse;
    public Tile wallHalfEastSparse;
    public Tile wallHalfSouthSparse;
    public Tile wallHalfWestSparse;

    public Tile wallHalfNorthMedium;
    public Tile wallHalfEastMedium;
    public Tile wallHalfSouthMedium;
    public Tile wallHalfWestMedium;

    public Tile wallHalfNorthDense;
    public Tile wallHalfEastDense;
    public Tile wallHalfSouthDense;
    public Tile wallHalfWestDense;

    public WallTiles(Color floorColor, Color floorDecorationColor, Color wallColor) {
        this(Color.black, floorColor, floorDecorationColor, wallColor);
    }

    public WallTiles(Color backgroundColor, Color floorColor, Color floorDecorationColor, Color wallColor) {
        super(backgroundColor, floorColor, floorDecorationColor);
        this.wallColor = wallColor;

        createCorners();
        createHalves();
    }

    private void createCorners() {
        createSmoothCorners();
        createSparseCorners();
        createMediumCorners();
        createDenseCorners();
    }

    private void createSmoothCorners() {
        this.wallCornerNESmooth = createTile(
                new ColoredTile(Tileset.LINE_1100, wallColor),
                this.floorCornerNESmooth
        );

        this.wallCornerSESmooth = createTile(
                new ColoredTile(Tileset.LINE_0110, wallColor),
                this.floorCornerSESmooth
        );

        this.wallCornerSWSmooth = createTile(
                new ColoredTile(Tileset.LINE_0011, wallColor),
                this.floorCornerSWSmooth
        );

        this.wallCornerNWSmooth = createTile(
                new ColoredTile(Tileset.LINE_1001, wallColor),
                this.floorCornerNWSmooth
        );
    }

    private void createSparseCorners() {
        this.wallCornerNESparse = createTile(
                new ColoredTile(Tileset.LINE_1100, wallColor),
                this.floorCornerNESparse
        );

        this.wallCornerSESparse = createTile(
                new ColoredTile(Tileset.LINE_0110, wallColor),
                this.floorCornerSESparse
        );

        this.wallCornerSWSparse = createTile(
                new ColoredTile(Tileset.LINE_0011, wallColor),
                this.floorCornerSWSparse
        );

        this.wallCornerNWSparse = createTile(
                new ColoredTile(Tileset.LINE_1001, wallColor),
                this.floorCornerNWSparse
        );
    }

    private void createMediumCorners() {
        this.wallCornerNEMedium = createTile(
                new ColoredTile(Tileset.LINE_1100, wallColor),
                this.floorCornerNEMedium
        );

        this.wallCornerSEMedium = createTile(
                new ColoredTile(Tileset.LINE_0110, wallColor),
                this.floorCornerSEMedium
        );

        this.wallCornerSWMedium = createTile(
                new ColoredTile(Tileset.LINE_0011, wallColor),
                this.floorCornerSWMedium
        );

        this.wallCornerNWMedium = createTile(
                new ColoredTile(Tileset.LINE_1001, wallColor),
                this.floorCornerNWMedium
        );
    }

    private void createDenseCorners() {
        this.wallCornerNEDense = createTile(
                new ColoredTile(Tileset.LINE_1100, wallColor),
                this.floorCornerNEDense
        );

        this.wallCornerSEDense = createTile(
                new ColoredTile(Tileset.LINE_0110, wallColor),
                this.floorCornerSEDense
        );

        this.wallCornerSWDense = createTile(
                new ColoredTile(Tileset.LINE_0011, wallColor),
                this.floorCornerSWDense
        );

        this.wallCornerNWDense = createTile(
                new ColoredTile(Tileset.LINE_1001, wallColor),
                this.floorCornerNWDense
        );
    }

    private void createHalves() {
        createSmoothHalves();
        createSparseHalves();
        createMediumHalves();
        createDenseHalves();
    }

    private void createSmoothHalves() {
        this.wallHalfNorthSmooth = createTile(
                new ColoredTile(Tileset.LINE_0101, wallColor),
                this.floorHalfNorthSmooth
        );

        this.wallHalfEastSmooth = createTile(
                new ColoredTile(Tileset.LINE_1010, wallColor),
                this.floorHalfEastSmooth
        );

        this.wallHalfSouthSmooth = createTile(
                new ColoredTile(Tileset.LINE_0101, wallColor),
                this.floorHalfSouthSmooth
        );

        this.wallHalfWestSmooth = createTile(
                new ColoredTile(Tileset.LINE_1010, wallColor),
                this.floorHalfWestSmooth
        );
    }

    private void createSparseHalves() {
        this.wallHalfNorthSparse = createTile(
                new ColoredTile(Tileset.LINE_0101, wallColor),
                this.floorHalfNorthSparse
        );

        this.wallHalfEastSparse = createTile(
                new ColoredTile(Tileset.LINE_1010, wallColor),
                this.floorHalfEastSparse
        );

        this.wallHalfSouthSparse = createTile(
                new ColoredTile(Tileset.LINE_0101, wallColor),
                this.floorHalfSouthSparse
        );

        this.wallHalfWestSparse = createTile(
                new ColoredTile(Tileset.LINE_1010, wallColor),
                this.floorHalfWestSparse
        );
    }

    private void createMediumHalves() {
        this.wallHalfNorthMedium = createTile(
                new ColoredTile(Tileset.LINE_0101, wallColor),
                this.floorHalfNorthMedium
        );

        this.wallHalfEastMedium = createTile(
                new ColoredTile(Tileset.LINE_1010, wallColor),
                this.floorHalfEastMedium
        );

        this.wallHalfSouthMedium = createTile(
                new ColoredTile(Tileset.LINE_0101, wallColor),
                this.floorHalfSouthMedium
        );

        this.wallHalfWestMedium = createTile(
                new ColoredTile(Tileset.LINE_1010, wallColor),
                this.floorHalfWestMedium
        );
    }

    private void createDenseHalves() {
        this.wallHalfNorthDense = createTile(
                new ColoredTile(Tileset.LINE_0101, wallColor),
                this.floorHalfNorthDense
        );

        this.wallHalfEastDense = createTile(
                new ColoredTile(Tileset.LINE_1010, wallColor),
                this.floorHalfEastDense
        );

        this.wallHalfSouthDense = createTile(
                new ColoredTile(Tileset.LINE_0101, wallColor),
                this.floorHalfSouthDense
        );

        this.wallHalfWestDense = createTile(
                new ColoredTile(Tileset.LINE_1010, wallColor),
                this.floorHalfWestDense
        );
    }

    private Tile createTile(Tile... layers) {
        return new LayeredTile(layers);
    }

    public Tile getTile(Direction direction, FloorDecoration floorDecoration) {
        return switch (direction) {
            case Full -> getFull(floorDecoration);
            case North -> getNorth(floorDecoration);
            case East -> getEast(floorDecoration);
            case South -> getSouth(floorDecoration);
            case West -> getWest(floorDecoration);
            case Northeast -> getNortheast(floorDecoration);
            case Southeast -> getSoutheast(floorDecoration);
            case Southwest -> getSouthwest(floorDecoration);
            case Northwest -> getNorthwest(floorDecoration);
        };
    }

    private Tile getSouthwest(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Smooth -> wallCornerSWSmooth;
            case Sparse -> wallCornerSWSparse;
            case Medium -> wallCornerSWMedium;
            case Dense -> wallCornerSWDense;
        };
    }

    private Tile getNorthwest(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Smooth -> wallCornerNWSmooth;
            case Sparse -> wallCornerNWSparse;
            case Medium -> wallCornerNWMedium;
            case Dense -> wallCornerNWDense;
        };
    }

    private Tile getSoutheast(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Smooth -> wallCornerSESmooth;
            case Sparse -> wallCornerSESparse;
            case Medium -> wallCornerSEMedium;
            case Dense -> wallCornerSEDense;
        };
    }

    private Tile getNortheast(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Smooth -> wallCornerNESmooth;
            case Sparse -> wallCornerNESparse;
            case Medium -> wallCornerNEMedium;
            case Dense -> wallCornerNEDense;
        };
    }

    private Tile getWest(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Smooth -> wallHalfWestSmooth;
            case Sparse -> wallHalfWestSparse;
            case Medium -> wallHalfWestMedium;
            case Dense -> wallHalfWestDense;
        };
    }

    private Tile getSouth(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Smooth -> wallHalfSouthSmooth;
            case Sparse -> wallHalfSouthSparse;
            case Medium -> wallHalfSouthMedium;
            case Dense -> wallHalfSouthDense;
        };
    }

    private Tile getEast(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Smooth -> wallHalfEastSmooth;
            case Sparse -> wallHalfEastSparse;
            case Medium -> wallHalfEastMedium;
            case Dense -> wallHalfEastDense;
        };
    }

    public Tile getFull(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Smooth -> floorFullSmooth;
            case Sparse -> floorFullSparse;
            case Medium -> floorFullMedium;
            case Dense -> floorFullDense;
        };
    }

    public Tile getNorth(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Smooth -> wallHalfNorthSmooth;
            case Sparse -> wallHalfNorthSparse;
            case Medium -> wallHalfNorthMedium;
            case Dense -> wallHalfNorthDense;
        };
    }
}
