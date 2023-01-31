package com.epam.rd.autotasks;

import java.util.List;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        if (ships == 0L) {
            throw new IllegalArgumentException("Ship must not be 0");
        }
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        if (shot == null || !shot.matches("[A-H][1-8]")) {
            throw new IllegalArgumentException("Send proper shot");
        }
        String letter = shot.substring(0, 1);
        int number = Integer.parseInt(shot.substring(1));
        long currentShot = makeShotLong(letter, number);
        shots = shots | currentShot;
        return (ships & currentShot) != 0L;
    }

    public String state() {
        String shipsString = longToBinaryString(ships);
        String shotsString = longToBinaryString(shots);
        String state = "";
        for (int i = 1; i <= 64; i++) {
            String ship = shipsString.substring(i - 1, i);
            String shot = shotsString.substring(i - 1, i);

            if (ship.equals("0") && shot.equals("0")) {
                state = state.concat(".");
                continue;
            }
            if (ship.equals("0") && shot.equals("1")) {
                state = state.concat("×");
                continue;
            }
            if (ship.equals("1") && shot.equals("0")) {
                state = state.concat("☐");
                continue;
            }
            if (ship.equals("1") && shot.equals("1")) {
                state = state.concat("☒");
                continue;
            }
            break;
        }
        String finState = "";
        for (int i = 0; i < state.length(); i += 8) {
            finState = finState.concat(state.substring(i, i + 8) + "\n");
        }
        return finState;
    }

    private long makeShotLong(String letter, int number) {
        List<String> letters = List.of("A", "B", "C", "D", "E", "F", "G", "H");
        int shift = letters.indexOf(letter) + ((number - 1) * 8);
        return 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L >>> shift;
    }

    private String longToBinaryString(long initialLong) {
        int leadingZeros = Long.numberOfLeadingZeros(initialLong);
        String result = "";
        for (int i = 0; i < leadingZeros; i++) {
            result = result.concat("0");
        }
        result += Long.toBinaryString(initialLong);
        return result;
    }
}
