public class Line {
    public final int k;
    public final int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        if (this.k == other.k) {
            return null;
        } else if (this.b == other.b) {
            return new Point(0, b);
        } else {
            int x = (this.b - other.b) / (other.k - this.k);
            int y = (this.k * x) + this.b;
            return new Point(x, y);
        }
    }
}
