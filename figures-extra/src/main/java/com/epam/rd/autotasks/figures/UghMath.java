package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;

public class UghMath {

    public static double sideLength(Point one, Point two) {
        double sideLen;
        double deltaX = one.getX() - two.getX();
        if (deltaX < 0) {
            deltaX = - deltaX;
        }
        double deltaY = one.getY() - two.getY();
        if (deltaY < 0) {
            deltaY = - deltaY;
        }
        sideLen = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return sideLen;
    }

    public static boolean isDegenerate(Point a, Point b, Point c) {
        double firstSide = sideLength(a, b);
        double secondSide = sideLength(a, c);
        double thirdSide = sideLength(b, c);


        if (firstSide + secondSide <= thirdSide + 0.0001 ||
                firstSide + thirdSide <= secondSide + 0.0001 ||
                secondSide + thirdSide <= firstSide + 0.0001) {
            return true;
        } else {
            return false;
        }
    }

}


