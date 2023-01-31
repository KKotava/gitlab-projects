import java.util.ArrayList;
import java.util.Scanner;

public class MaxValue {
    public static int max() {
        ArrayList<Integer> findingMax = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        int elem = 7;
        while (elem != 0) {
            elem = scanner.nextInt();
            if (elem == 0) {
                continue;
            } else {
                findingMax.add(elem);
            }
        }
        int size = findingMax.size();
        int largest = findingMax.get(0);
        for (int i = 1; i < size; i++) {
            if (findingMax.get(i) > largest) {
                largest = findingMax.get(i);
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        System.out.println(max());
    }
}
