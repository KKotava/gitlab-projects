import java.util.Arrays;

public class CycleSwap {
    public static void cycleSwap(int[] array) {
        cycleSwap(array, 1);
    }

    public static void cycleSwap(int[] array, int shift) {
        int temp = array.length;
        if (temp > 0 && temp != shift) {
            int[] result = Arrays.copyOf(array, temp);
            System.arraycopy(result, temp - shift, array, 0, shift);
            System.arraycopy(result, 0, array, shift, temp - shift);
        }
    }
}

