package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

public class Segment {
    Point start;

    Point end;

    public Segment(Point start, Point end) {
        if (start == null) {
            throw new NullPointerException("start is marked non-null but is null");
        } else if (end == null) {
            throw new NullPointerException("end is marked non-null but is null");
        } else if (start.equals(end)) {
            throw new IllegalArgumentException("Points are the same, but should not be the same, because I want it in the constructor");
        } else {
            this.start = start;
            this.end = end;
        }
    }

    boolean equals(Segment segment) {
        boolean st = this.start.equals(segment.start);
        boolean en = this.end.equals(segment.end);
        return st && en;
    }


    Point intersection(Segment another) {
        if (another == null || another.start == null || another.end == null || this.equals(another)) {
            return null;
        }
        if (this.end.getX() < this.start.getX()) {
            Point tmp = this.start;
            this.start = this.end;
            this.end = tmp;
        }
        if (another.end.getX() < another.start.getX()) {
            Point tmp = another.start;
            another.start = another.end;
            another.end = tmp;
        }

        if ((this.end.getX() <= another.start.getX()) ||
                this.start.equals(this.end) ||
                another.start.equals(another.end)) {
            return null;
        }

        double slopeThis;
        double slopeAnother;

        // check naklon
        if (this.start.getY() == this.end.getY()) {
            slopeThis = 0;
        } else {
            slopeThis = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        }
        if (another.start.getY() == another.end.getY()) {
            slopeAnother = 0;
        } else {
            slopeAnother = (another.end.getY() - another.start.getY()) / (another.end.getX() - another.start.getX());
        }

        if (slopeThis == slopeAnother) {
            return null;
        }

        double freeThis = this.start.getY() - slopeThis * this.start.getX();
        double freeAnother = another.start.getY() - slopeAnother * another.start.getX();
        double interX = (freeAnother - freeThis) / (slopeThis - slopeAnother);
        double interY = slopeThis * interX + freeThis;

        if (!(this.getStart().getX() <= another.getStart().getX())) {
            Segment transfer = this;
            this.setStart(another.getStart());
            this.setEnd(another.getEnd());
            another = transfer;
        }
        if (((this.start.getX() < another.end.getX() && another.end.getX() < this.end.getX()) ||
                (this.start.getX() < another.start.getX() && another.start.getX() < this.end.getX())) &&
                (another.start.getX() < interX && interX < this.end.getX())) {
            return new Point(interX, interY);
        } else {
            return null;
        }
    }


    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
