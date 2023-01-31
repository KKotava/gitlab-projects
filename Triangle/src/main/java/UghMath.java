import static java.lang.Math.sqrt;

public class UghMath {
    public static double sideLength (Point one, Point two){
        double sideLen;
        double deltaX = one.getX() - two.getX();
        double deltaY = one.getY() - two.getY();
        sideLen = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return sideLen;
    }

    public static boolean isDegenerate (Point a, Point b, Point c) {
        boolean deg;
        double firstSide = sideLength(a, b);
        double secondSide = sideLength(a, c);
        double thirdSide = sideLength(b, c);


        if (firstSide + secondSide <= thirdSide ||
            firstSide + thirdSide <= secondSide ||
            secondSide + thirdSide <= firstSide) {
            deg = true;
        } else {
            deg = false;
        }
        return deg;
    }

    public static double square(Triangle triangle) {
        double firstSide = sideLength(triangle.getA(), triangle.getB());
        double secondSide = sideLength(triangle.getA(), triangle.getC());
        double thirdSide = sideLength(triangle.getB(), triangle.getC());
        double per = (firstSide + secondSide + thirdSide) / 2.0;
        double square = sqrt(per * (per - firstSide) * (per - secondSide) * (per - thirdSide));
        return square;
    }
}
