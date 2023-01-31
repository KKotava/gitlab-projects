package com.epam.rd.autotasks;

import java.util.Arrays;

public enum FieldState {
    EMPTY_CELL {
        @Override
        public boolean check (String shipField, String shotField) {
            if (shipField.equals("0") && shotField.equals("0")) {
                return true;
            }
            return false;
        }
        @Override
        public String toString() {
            return ".";
        }
    },
    EMPTY_SHOTTED_CELL {
        @Override
        public boolean check (String shipField, String shotField) {
            if (shipField.equals("0") && shotField.equals("1")) {
                return true;
            }
            return false;
        }
        @Override
        public String toString() {
            return "×";
        }
    },
    CELL_WITH_SHIP {
        @Override
        public boolean check (String shipField, String shotField) {
            if (shipField.equals("1") && shotField.equals("0")) {
                return true;
            }
            return false;
        }
        @Override
        public String toString() {
            return "☐";
        }
    },
    CELL_WITH_SHOTTED_SHIP {
        @Override
        public boolean check (String shipField, String shotField) {
            if (shipField.equals("1") && shotField.equals("1")) {
                return true;
            }
            return false;
        }
        @Override
        public String toString() {
            return "☒";
        }
    };

    public abstract boolean check(String shipField, String shotField);


//    EMPTY_CELL        (".", false, "0", "0"),
//    EMPTY_SHOTTED_CELL("×", false, "0", "1");
//
//    public boolean check(String ship, String shot) {
//        return Arrays.stream(FieldState.values())
//                .filter(fieldState -> ship.equals(fieldState.shipState) && shot.equals(fieldState.shotState))
//                .findFirst()
//                .get().stateBoolean;
//    }
}
