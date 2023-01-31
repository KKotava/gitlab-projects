package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;

public class UghMath {
    public static double sideLength (Point one, Point two){
        double deltaX = one.getX() - two.getX();
        double deltaY = one.getY() - two.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public static double square(Triangle triangle) {
        double firstSide = sideLength(triangle.getFirst(), triangle.getSecond());
        double secondSide = sideLength(triangle.getFirst(), triangle.getThird());
        double thirdSide = sideLength(triangle.getSecond(), triangle.getThird());
        double per = (firstSide + secondSide + thirdSide) / 2.0;
        double square = sqrt(per * (per - firstSide) * (per - secondSide) * (per - thirdSide));
        return square;
    }

    public static double quadroSquare(Quadrilateral quadro) {
        double firstSide = sideLength(quadro.getFirst(), quadro.getSecond());
        double secondSide = sideLength(quadro.getSecond(), quadro.getThird());
        double thirdSide = sideLength(quadro.getThird(), quadro.getFourth());
        double fourthSide = sideLength(quadro.getFourth(), quadro.getFirst());
        double halfPer = (firstSide + secondSide + thirdSide + fourthSide) / 2;
        double almostThere = (halfPer - firstSide) * (halfPer - secondSide) * (halfPer - thirdSide) * (halfPer - fourthSide);
        return sqrt(almostThere);
    }

}
