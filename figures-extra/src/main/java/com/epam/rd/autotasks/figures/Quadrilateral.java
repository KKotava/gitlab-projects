package com.epam.rd.autotasks.figures;

import java.util.*;

class Quadrilateral extends Figure {
    private Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        verifyVerticesAreNotNull(a, b, c, d);
        verifyNotDegenerative(a, b, c, d);
        verifyNotConvex(a, b, c, d);
        verifyNotPlain(a, b, c, d);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    private void verifyNotDegenerative(Point a, Point b, Point c, Point d) {
        if (Triangle.calculateArea(a, b, c) == 0
                || Triangle.calculateArea(a, b, d) == 0
                || Triangle.calculateArea(a, c, d) == 0
                || Triangle.calculateArea(b, c, d) == 0) {
            throw new IllegalArgumentException("Quadrilateral is degenerative");
        }
    }

    private void verifyNotConvex(Point a, Point b, Point c, Point d) {
        boolean combination1IsConvex = checkIsConvex(a, b, c, d);
        boolean combination2IsConvex = checkIsConvex(b, a, c, d);
        boolean combination3IsConvex = checkIsConvex(c, a, b, d);
        boolean combination4IsConvex = checkIsConvex(d, a, b, c);
        if (!(combination1IsConvex && combination2IsConvex && combination3IsConvex && combination4IsConvex)) {
            throw new IllegalArgumentException("Quadrilateral is not convex");
        }
    }

    private boolean checkIsConvex(Point a, Point b, Point c, Point d) {
        double area1 = Triangle.calculateArea(a, b, c);
        double area2 = Triangle.calculateArea(a, b, d);
        double area3 = Triangle.calculateArea(a, c, d);
        double area4 = Triangle.calculateArea(b, c, d);
        if (area1 + area2 + area3 == area4) {
            return false;
        }
        return true;
    }

    private void verifyNotPlain(Point a, Point b, Point c, Point d) {
        if (areSegmentsIntersecting(new Segment(b, c), new Segment(a, d))
                || areSegmentsIntersecting(new Segment(a, b), new Segment(c, d))
        ) {
            throw new IllegalArgumentException("Quadrilateral is plain");
        }
    }

    private void verifyVerticesAreNotNull(Point a, Point b, Point c, Point d) {
        if (Objects.isNull(a) || Objects.isNull(b) || Objects.isNull(c) || Objects.isNull(d)) {
            throw new IllegalArgumentException("Points should not be null");
        }
    }

    @Override
    public Point centroid() {
        Point center1 = new Triangle(a,b,c).centroid();
        Point center2 = new Triangle(a,c,d).centroid();
        Point center3 = new Triangle(a,d,b).centroid();
        Point center4 = new Triangle(b,d,c).centroid();

        return new Segment(center1,center2)
                .findIntersectionPoint(new Segment(center3,center4));
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (this.getClass() != figure.getClass()) {
            return false;
        }
        return this.equals((Quadrilateral) figure);
    }

    private boolean equals(Quadrilateral otherQuad) {
        List<Point> thisPoints = new ArrayList<>() {{
            add(a);
            add(b);
            add(c);
            add(d);
        }};
        List<Point> otherPoints = new ArrayList<>() {{
            add(otherQuad.getA());
            add(otherQuad.getB());
            add(otherQuad.getC());
            add(otherQuad.getD());
        }};
        return thisPoints.containsAll(otherPoints);
    }

    private boolean areSegmentsIntersecting(Segment s1, Segment s2) {
        Point a = s1.getStart();
        Point b = s1.getEnd();
        Point c = s2.getStart();
        Point d = s2.getEnd();
        return ((isCcw(a, c, d) != (isCcw(b, c, d))) && (isCcw(a, b, c) != isCcw(a, b, d)));
    }

    private boolean isCcw(Point a, Point b, Point c) {
        return (((c.getY() - a.getY()) * (b.getX() - a.getX())) > ((b.getY() - a.getY()) * (c.getX() - a.getX())));
    }

    private class Segment {
        private Point start, end;

        public Segment(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        public Point getStart() {
            return start;
        }

        public Point getEnd() {
            return end;
        }

        private Point findIntersectionPoint(Segment another) {
            double k1 = (end.getY() - start.getY()) / (end.getX() - start.getX());
            double k2 = (another.end.getY() - another.start.getY()) / (another.end.getX() - another.start.getX());
            if (k1 == k2) return null;

            double b1 = (start.getY() * end.getX() - end.getY() * start.getX()) / (end.getX() - start.getX());
            double b2 = (another.start.getY() * another.end.getX() - another.end.getY() * another.start.getX()) /
                    (another.end.getX() - another.start.getX());

            double x = (b2 - b1) / (k1 - k2);
            double y = (k1 * b2 - k2 * b1) / (k1 - k2);

            if ((x > start.getX() && x > end.getX()) || (x > another.start.getX() && x > another.end.getX()) ||
                    (x < start.getX() && x < end.getX()) || (x < another.start.getX() && x < another.end.getX()) ||
                    (y > start.getY() && y > end.getY()) || (y > another.start.getY() && y > another.end.getY()) ||
                    (y < start.getY() && y < end.getY()) || (y < another.start.getY() && y < another.end.getY()))
                return null;
            return new Point(x, y);
        }
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }
}
