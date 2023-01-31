public class Point {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean equals (Point point) {
        boolean checkXs = Double.valueOf(this.x).equals(Double.valueOf(point.x));
        boolean checkYs = Double.valueOf(this.y).equals(Double.valueOf(point.y));
        return checkXs && checkYs;
    }
}
