package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Point {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        double delta = 0.00001;
        return Math.abs(x - point.x) < delta && Math.abs(y - point.y) < delta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
