import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

public class Triangle {
    private Point a, b, c;


    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null ||
                a.equals(b) || a.equals(c) || b.equals(c)) {
            throw new IllegalArgumentException("Triangle is not existing");
        } else if (UghMath.isDegenerate(a, b, c)){
            throw new IllegalArgumentException("Triangle is degenerate");
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public double area() {
        return UghMath.square(this);
    }

    public Point centroid(){
        double centX = ((a.getX() + b.getX() + c.getX()) / 3);
        double centY = ((a.getY() + b.getY() + c.getY()) / 3);
        return new Point (centX, centY);
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
}
