import java.util.Arrays;

public class MultiplyMatrix {

    public static int[][] multiply (int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1rows2 = matrix2.length; //and matrix1[0].length too
        int columns2 = matrix2[0].length;
        int[][] result = new int [rows1][columns2];

        if (matrix1[0].length != matrix2.length || matrix1 == null || matrix2 == null) {
            return null;
        }

        for (int i = 0; i < rows1; i++) {
            for (int y = 0; y < columns2; y++) {
                for (int j = 0; j < columns1rows2; j++) {
                    result[i][y] += matrix1[i][j] * matrix2[j][y];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
            System.out.println("Test your code here!\n");

    // Get a result of your code

        int[][] a = { {1, 2}, {7, -13} };
        int[][] b = { {1, 2}, {7, -13} };

    int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
}


}
