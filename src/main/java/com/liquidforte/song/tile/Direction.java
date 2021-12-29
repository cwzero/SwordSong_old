package com.liquidforte.song.tile;

public enum Direction {
    North, East, South, West, Northeast, Southeast, Southwest, Northwest, Full;

    public static Direction getDirection(boolean north, boolean east, boolean south, boolean west) {
        if ((north && south) || (east && west)) {
            throw new RuntimeException();
        } else {
            if (!north && !east && !south && !west) {
                return Direction.Full;
            } else if ((north || south) && (east || west)) {
                if (north && east) {
                    return Northeast;
                } else if (south && east) {
                    return Southeast;
                } else if (south) {
                    return Southwest;
                } else {
                    return Northwest;
                }
            } else {
                if (north) {
                    return North;
                } else if (east) {
                    return East;
                } else if (south) {
                    return South;
                } else {
                    return West;
                }
            }
        }
    }
}
