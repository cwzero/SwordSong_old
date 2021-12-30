package com.liquidforte.song.tile;

import com.liquidforte.song.util.Tileset;

import java.awt.*;

public class RoomTiles extends FloorTiles {
    private final Color wallColor;

    public Tile wallCornerNEBlank;
    public Tile wallCornerSEBlank;
    public Tile wallCornerSWBlank;
    public Tile wallCornerNWBlank;

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

    public Tile wallHalfNorthBlank;
    public Tile wallHalfEastBlank;
    public Tile wallHalfSouthBlank;
    public Tile wallHalfWestBlank;

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

    // TODO: color schemes
    public RoomTiles(Color floorColor, Color floorDecorationColor, Color wallColor) {
        this(Color.black, floorColor, floorDecorationColor, wallColor);
    }

    public RoomTiles(Color backgroundColor, Color floorColor, Color floorDecorationColor, Color wallColor) {
        super(backgroundColor, floorColor, floorDecorationColor);
        this.wallColor = wallColor;

        createCorners();
        createHalves();
    }

    private void createCorners() {
        createBlankCorners();
        createSmoothCorners();
        createSparseCorners();
        createMediumCorners();
        createDenseCorners();
    }

    private void createBlankCorners() {
        this.wallCornerNEBlank = new ColoredTile(Tileset.LINE_1100, wallColor);
        this.wallCornerSEBlank = new ColoredTile(Tileset.LINE_0110, wallColor);
        this.wallCornerSWBlank = new ColoredTile(Tileset.LINE_0011, wallColor);
        this.wallCornerNWBlank = new ColoredTile(Tileset.LINE_1001, wallColor);
    }

    private void createSmoothCorners() {
        this.wallCornerNESmooth = createTile(
                this.wallCornerNEBlank,
                this.floorCornerNESmooth
        );

        this.wallCornerSESmooth = createTile(
                this.wallCornerSEBlank,
                this.floorCornerSESmooth
        );

        this.wallCornerSWSmooth = createTile(
                this.wallCornerSWBlank,
                this.floorCornerSWSmooth
        );

        this.wallCornerNWSmooth = createTile(
                this.wallCornerNWBlank,
                this.floorCornerNWSmooth
        );
    }

    private void createSparseCorners() {
        this.wallCornerNESparse = createTile(
                this.wallCornerNEBlank,
                this.floorCornerNESparse
        );

        this.wallCornerSESparse = createTile(
                this.wallCornerSEBlank,
                this.floorCornerSESparse
        );

        this.wallCornerSWSparse = createTile(
                this.wallCornerSWBlank,
                this.floorCornerSWSparse
        );

        this.wallCornerNWSparse = createTile(
                this.wallCornerNWBlank,
                this.floorCornerNWSparse
        );
    }

    private void createMediumCorners() {
        this.wallCornerNEMedium = createTile(
                this.wallCornerNEBlank,
                this.floorCornerNEMedium
        );

        this.wallCornerSEMedium = createTile(
                this.wallCornerSEBlank,
                this.floorCornerSEMedium
        );

        this.wallCornerSWMedium = createTile(
                this.wallCornerSWBlank,
                this.floorCornerSWMedium
        );

        this.wallCornerNWMedium = createTile(
                this.wallCornerNWBlank,
                this.floorCornerNWMedium
        );
    }

    private void createDenseCorners() {
        this.wallCornerNEDense = createTile(
                this.wallCornerNEBlank,
                this.floorCornerNEDense
        );

        this.wallCornerSEDense = createTile(
                this.wallCornerSEBlank,
                this.floorCornerSEDense
        );

        this.wallCornerSWDense = createTile(
                this.wallCornerSWBlank,
                this.floorCornerSWDense
        );

        this.wallCornerNWDense = createTile(
                this.wallCornerNWBlank,
                this.floorCornerNWDense
        );
    }

    private void createHalves() {
        createBlankHalves();
        createSmoothHalves();
        createSparseHalves();
        createMediumHalves();
        createDenseHalves();
    }

    private void createBlankHalves() {
        this.wallHalfNorthBlank = new ColoredTile(Tileset.LINE_0101, wallColor);
        this.wallHalfEastBlank = new ColoredTile(Tileset.LINE_1010, wallColor);
        this.wallHalfSouthBlank = new ColoredTile(Tileset.LINE_0101, wallColor);
        this.wallHalfWestBlank = new ColoredTile(Tileset.LINE_1010, wallColor);
    }

    private void createSmoothHalves() {
        this.wallHalfNorthSmooth = createTile(
                this.wallHalfNorthBlank,
                this.floorHalfNorthSmooth
        );

        this.wallHalfEastSmooth = createTile(
                this.wallHalfEastBlank,
                this.floorHalfEastSmooth
        );

        this.wallHalfSouthSmooth = createTile(
                this.wallHalfSouthBlank,
                this.floorHalfSouthSmooth
        );

        this.wallHalfWestSmooth = createTile(
                this.wallHalfWestBlank,
                this.floorHalfWestSmooth
        );
    }

    private void createSparseHalves() {
        this.wallHalfNorthSparse = createTile(
                this.wallHalfNorthBlank,
                this.floorHalfNorthSparse
        );

        this.wallHalfEastSparse = createTile(
                this.wallHalfEastBlank,
                this.floorHalfEastSparse
        );

        this.wallHalfSouthSparse = createTile(
                this.wallHalfSouthBlank,
                this.floorHalfSouthSparse
        );

        this.wallHalfWestSparse = createTile(
                this.wallHalfWestBlank,
                this.floorHalfWestSparse
        );
    }

    private void createMediumHalves() {
        this.wallHalfNorthMedium = createTile(
                this.wallHalfNorthBlank,
                this.floorHalfNorthMedium
        );

        this.wallHalfEastMedium = createTile(
                this.wallHalfEastBlank,
                this.floorHalfEastMedium
        );

        this.wallHalfSouthMedium = createTile(
                new ColoredTile(Tileset.LINE_0101, wallColor),
                this.floorHalfSouthMedium
        );

        this.wallHalfWestMedium = createTile(
                this.wallHalfWestBlank,
                this.floorHalfWestMedium
        );
    }

    private void createDenseHalves() {
        this.wallHalfNorthDense = createTile(
                this.wallHalfNorthBlank,
                this.floorHalfNorthDense
        );

        this.wallHalfEastDense = createTile(
                this.wallHalfEastBlank,
                this.floorHalfEastDense
        );

        this.wallHalfSouthDense = createTile(
                this.wallHalfSouthBlank,
                this.floorHalfSouthDense
        );

        this.wallHalfWestDense = createTile(
                this.wallHalfWestBlank,
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
            case Blank -> wallCornerSWBlank;
            case Smooth -> wallCornerSWSmooth;
            case Sparse -> wallCornerSWSparse;
            case Medium -> wallCornerSWMedium;
            case Dense -> wallCornerSWDense;
        };
    }

    private Tile getNorthwest(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Blank -> wallCornerNWBlank;
            case Smooth -> wallCornerNWSmooth;
            case Sparse -> wallCornerNWSparse;
            case Medium -> wallCornerNWMedium;
            case Dense -> wallCornerNWDense;
        };
    }

    private Tile getSoutheast(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Blank -> wallCornerSEBlank;
            case Smooth -> wallCornerSESmooth;
            case Sparse -> wallCornerSESparse;
            case Medium -> wallCornerSEMedium;
            case Dense -> wallCornerSEDense;
        };
    }

    private Tile getNortheast(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Blank -> wallCornerNEBlank;
            case Smooth -> wallCornerNESmooth;
            case Sparse -> wallCornerNESparse;
            case Medium -> wallCornerNEMedium;
            case Dense -> wallCornerNEDense;
        };
    }

    private Tile getWest(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Blank -> wallHalfWestBlank;
            case Smooth -> wallHalfWestSmooth;
            case Sparse -> wallHalfWestSparse;
            case Medium -> wallHalfWestMedium;
            case Dense -> wallHalfWestDense;
        };
    }

    private Tile getSouth(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Blank -> wallHalfSouthBlank;
            case Smooth -> wallHalfSouthSmooth;
            case Sparse -> wallHalfSouthSparse;
            case Medium -> wallHalfSouthMedium;
            case Dense -> wallHalfSouthDense;
        };
    }

    private Tile getEast(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Blank -> wallHalfWestBlank;
            case Smooth -> wallHalfEastSmooth;
            case Sparse -> wallHalfEastSparse;
            case Medium -> wallHalfEastMedium;
            case Dense -> wallHalfEastDense;
        };
    }

    public Tile getFull(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Blank -> floorFullBlank;
            case Smooth -> floorFullSmooth;
            case Sparse -> floorFullSparse;
            case Medium -> floorFullMedium;
            case Dense -> floorFullDense;
        };
    }

    public Tile getNorth(FloorDecoration floorDecoration) {
        return switch (floorDecoration) {
            case Blank -> wallHalfNorthBlank;
            case Smooth -> wallHalfNorthSmooth;
            case Sparse -> wallHalfNorthSparse;
            case Medium -> wallHalfNorthMedium;
            case Dense -> wallHalfNorthDense;
        };
    }
}
