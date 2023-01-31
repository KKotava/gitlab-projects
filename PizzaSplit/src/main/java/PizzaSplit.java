import java.util.Scanner;

public class PizzaSplit {
    public static int greatestCommonDivisor (int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return greatestCommonDivisor(b, a%b);
        }
    }

    public static int leastCommonMultiple (int a, int b) {
        return (a * b) / greatestCommonDivisor(a, b);
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = scanner.nextInt();
        int pieces = scanner.nextInt();
        scanner.close();
        System.out.println(leastCommonMultiple(people, pieces) / pieces);

    }
}

//   Решение с просторов интернетов от кого-то, кто тоже решал
//   задачу. Ничего не понятно, но очень интересно.
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int people = scanner.nextInt();
//        int pieces = scanner.nextInt();
//        int pizza = 1;
//        int countOfPiec = pieces;
//
//        while(people > 0) {
//            pieces = countOfPiec;
//            pieces *= pizza;
//            if(pieces % people == 0){
//                break;
//            }
//            pizza++;
//        }
//        System.out.println(pizza);
//
//
//    }
//}