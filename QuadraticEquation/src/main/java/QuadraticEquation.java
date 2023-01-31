import java.text.DecimalFormat;
import java.util.Scanner;

public class QuadraticEquation {
    public static void main (String[] args) {
//        a * (x * x) + b * x + c = 0
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.#");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        scanner.close();
        double d = ((b * b) - (4 * a * c));
        if (d < 0) {
            System.out.println("no roots");
        } else if (d == 0) {
            String util = df.format((-b - Math.sqrt(d)) / (2 * a));
            System.out.println(util);
        } else {
            double x1 = (-b - Math.sqrt(d)) / (2 * a);
            String y1 = df.format(x1);
            double x2 = (-b + Math.sqrt(d)) / (2 * a);
            String y2 = df.format(x2);
            System.out.println(y1 + " " + y2);
        }

    }
}
