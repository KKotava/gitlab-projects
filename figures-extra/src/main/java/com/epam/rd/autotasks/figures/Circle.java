package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Circle extends Figure {
    Point center;
    double diameter;
    double radius;

    public Circle(Point center, double diameter) {
        verifyCenter(center);
        verifyDiameter(diameter);
        this.center = center;
        this.diameter = diameter;
        this.radius = diameter / 2;
    }

    private void verifyDiameter(double diameter) {
        if (diameter <= 0) {
            throw new IllegalArgumentException("Diameter should be greater than zero");
        }
    }

    private void verifyCenter(Point center) {
        if (Objects.isNull(center)) {
            throw new IllegalArgumentException("Center point should not be null");
        }
    }

    @Override
    public Point centroid() {
        return this.center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (this.getClass() != figure.getClass()) {
            return false;
        }
        return this.equals((Circle) figure);
    }

    private boolean equals(Circle otherCircle) {
        if (!this.center.equals(otherCircle.center)) {
            return false;
        }
        double delta = 0.00001;
        return Math.abs(this.diameter - otherCircle.diameter) < delta;
    }
}
