package com.epam.rd.autotasks.figures;

class Point {
    private double x;

    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }


    public boolean equals (Point point) {
        boolean checkXs = Double.valueOf(this.x).equals(Double.valueOf(point.x));
        boolean checkYs = Double.valueOf(this.y).equals(Double.valueOf(point.y));
        return checkXs && checkYs;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
