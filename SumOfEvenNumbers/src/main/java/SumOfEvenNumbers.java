public class SumOfEvenNumbers {
    public static int sum(int[] array){

        int result = 0;
        if (array == null) {
            return result;
        } else {
            for (int i : array) {
                if ((i % 2) == 0) {
                    result = result + i;
                }
            }
            return result;
        }

    }

//    public static void main (String[] args) {
//        int[] vals = new int[]{-2, 10, 0, 5};
//        int result = SumOfEvenNumbers.sum(vals);
//        System.out.println(result == 8);
//    }
public static void main(String[] args) {
//    int[] array = new int[]{1, 3, 2, 8, 15, 199};
//    int[] array = null;
        int[] array = new int[0];
    System.out.println(sum(array));
}
}
