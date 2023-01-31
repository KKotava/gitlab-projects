//public class MaxMethod {
//
//    public static int max (int[] values) {
//        int result = values[0];
//        for (int i : values) {
//            if (result < i) {
//                result = i;
//            }
//        }
//        return result;
//    }
//
//
//    public static void main (String[] args) {
////        int[] vals = new int[] {-2, 0, 10, 5};
////        int result = MaxMethod.max(vals);
////        System.out.println(result == 10);
//        int[] values = new int[]{-10, 3, 255528, 0, Integer.MAX_VALUE, 100, 0};
//        int result = MaxMethod.max(values);
//        System.out.println(Integer.MAX_VALUE == result);
//    }
//
//}



public class MaxMethod {
    public static int max(int[] values) {
        int result = values[0];
        for (int i : values) {
            if (result < i) {
                result = i;
            }
        }
        return result;
    }
}
