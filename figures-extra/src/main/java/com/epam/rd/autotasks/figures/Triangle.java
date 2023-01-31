package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Triangle extends Figure {
    Point a;
    Point b;
    Point c;

    public Triangle(Point a, Point b, Point c) {
        verifyVerticesAreNotNull(a, b, c);
        verifyTriangleIsNotDegenerative(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private void verifyTriangleIsNotDegenerative(Point a, Point b, Point c) {
        if (calculateArea(a, b, c) <= 0) {
            throw new IllegalArgumentException("Triangle should not be degenerative");
        }
    }

    private void verifyVerticesAreNotNull(Point a, Point b, Point c) {
        if (Objects.isNull(a) || Objects.isNull(b) || Objects.isNull(c)) {
            throw new IllegalArgumentException("Points should not be null");
        }
    }

    public static double calculateArea(Point a, Point b, Point c) {
        return Math.abs(
                        (a.getX() * (b.getY() - c.getY())) +
                        (b.getX() * (c.getY() - a.getY())) +
                        (c.getX() * (a.getY() - b.getY()))
        ) / 2;
    }

    @Override
    public Point centroid() {
        double centX = ((a.getX() + b.getX() + c.getX()) / 3);
        double centY = ((a.getY() + b.getY() + c.getY()) / 3);
        return new Point (centX, centY);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }
}
