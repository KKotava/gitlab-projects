package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    private Point first;

    private Point second;
    private Point third;
    private Point fourth;

    public Quadrilateral(Point first, Point second, Point third, Point fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    @Override
    public double area() {
//        orderingPointsByY();
//        return UghMath.quadroSquare(this);
        Triangle triangleFirst = new Triangle(first, third, fourth);
        Triangle triangleSecond = new Triangle(first, second, third);
        double square1 = triangleFirst.area();
        double square2 = triangleSecond.area();
        return square1 + square2;
    }

    @Override
    public String pointsToString() {
        return first.toString() + second.toString() + third.toString() + fourth.toString();
    }

    @Override
    public Point leftmostPoint() {
        orderingPointsByX();
        return first;
    }


    private void orderingPointsByX () {
        Point[] arr = {first, second, third, fourth};
        Point temp;
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].getX() > arr[j + 1].getX()) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        first = arr[0];
        second = arr[1];
        third = arr[2];
        fourth = arr[3];
    }

    private void orderingPointsByY() {
        orderingPointsByX();
        Point[] arr = {first, second, third, fourth};
        if (arr[0].getY() > arr[1].getY()) {
            first = arr[0];
            second = arr[1];
        } else {
            first = arr[1];
            second = arr[0];
        }
        if (arr[2].getY() > arr[3].getY()) {
            third = arr[2];
            fourth = arr[3];
        } else {
            third = arr[2];
            fourth = arr[3];
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

    public Point getFourth() {
        return fourth;
    }
}
