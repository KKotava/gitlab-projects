package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private final Point first;
    private final Point second;
    private final Point third;
    public Triangle (Point first, Point second, Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public double area() {
        return UghMath.square(this);

    }

    @Override
    public String pointsToString() {
        return first.toString() + second.toString() + third.toString();
    }

    @Override
    public Point leftmostPoint() {
        double semiFinal = Math.min(first.getX(), second.getX());
        double fFinal = Math.min(third.getX(), semiFinal);
        if (fFinal == first.getX()) {
            return first;
        } else if (fFinal == second.getX()) {
            return second;
        } else {
            return third;
        }
    }




    public Point getFirst() {
        return first;
    }

    public Point getSecond() {
        return second;
    }

    public Point getThird() {
        return third;
    }
}
