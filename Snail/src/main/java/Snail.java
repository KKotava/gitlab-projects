import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int h = scanner.nextInt();
        if (a > b) {
            System.out.println((h - a) / (a - b) + 1);
        } else if (a >= h) {
            System.out.println(1);
        } else {
            System.out.println("Impossible");
        }
        scanner.close();
        //5 3 12 wrong answer, try to use Math.methods
    }
}
