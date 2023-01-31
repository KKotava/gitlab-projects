import java.util.Arrays;

public class LocalMaximaRemove {
    public static int[] removeLocalMaxima (int[] array) {
        int[] result = new int[array.length];
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if ((i > 0 && array[i] <= array[i - 1]) || (i != array.length - 1 && array[i] <= array[i + 1])){
                result[temp++] = array[i];
            }
        }
        return Arrays.copyOf(result, temp);
    }


    public static void main (String[] args) {
        int[] array = new int[]
//                {18, 1, 3, 6, 7, -5};
                {-3, 2, 4, 3, 5, 12, 8};
        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }
}
