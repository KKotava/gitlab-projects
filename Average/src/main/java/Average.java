import java.util.ArrayList;
import java.util.Scanner;

public class Average {
    public static void main (String[] args) {
        ArrayList<Integer> middle = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        int elem = 7;
        while (elem != 0) {
            elem = scanner.nextInt();
            if (elem == 0) {
                continue;
            } else {
                middle.add(elem);
            }
        }
        int size = middle.size();
        int sum = middle.get(0);
        for (int i = 1; i < size; i++) {
            sum = sum + middle.get(i);
        }
        System.out.println(sum / size);
    }
}
