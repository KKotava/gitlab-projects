package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N( 0, 180),
    NE(45, 225),
    E(90, 270),
    SE(135, 315),
    S(180, 0),
    SW(225, 45),
    W(270, 90),
    NW(315, 135);

    Direction(final int degrees, final int oppositeDegrees) {
        this.degrees = degrees;
        this.oppositeDegrees = oppositeDegrees;
    }

    private int degrees;
    private int oppositeDegrees;

    public static Direction ofDegrees(int degrees) {
        degrees = ordering(degrees);
        Direction[] directions = Direction.values();
        for (int i = 0; i < directions.length; i++) {
            if (degrees == directions[i].degrees) {
                return directions[i];
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = ordering(degrees);
        Direction[] directions = Direction.values();
        int[] difference = new int[directions.length];
        for (int i = 0; i < directions.length; i++) {
            difference[i] = directions[i].degrees - degrees;
            if (difference[i] < 0) {
                difference[i] = -difference[i];
            }
        }
        int min = difference[0];
        int fMin = 0;
        for (int i = 0; i < difference.length; i++) {
            if (difference[i] < min) {
                min = difference[i];
                fMin = i;
            }
        }
        return directions[fMin];
    }

    public Direction opposite() {
        if (this.degrees + 180 > 315) {
            return ofDegrees(this.degrees - 180);
        }
        return ofDegrees(this.degrees + 180);
    }

    public int differenceDegreesTo(Direction direction) {
        if (this.degrees == 0 && direction.degrees == 315) {
            return 45;
        }
        return Math.abs(direction.degrees - this.degrees);
    }

    private static int ordering (int degrees) {
        while (degrees >= 360) {
            degrees = degrees - 360;
        }
        while (degrees < 0) {
            degrees = degrees + 360;
        }
        return degrees;
    }
}
