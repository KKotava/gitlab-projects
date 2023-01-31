public class TransposeMatrix {
    public static int[][] multiply (int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] source = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                source[j][i] = matrix[i][j];
            }
        }

        return source;
    }


    //for square matrix
    public static int[][] multiply2 (int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array[0].length; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }

        return array;
    }

    //if need void for square
    public static void multiply3(int [][] array){

        int rows = array.length;
        int columns = array[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = i + 1; j<columns; j++){
                array[i][j] = array[i][j] + array[j][i];
                array[j][i] = array[i][j] - array[j][i];
                array[i][j] = array[i][j] - array[j][i];
            }
        }
    }

    public static void main(String[] args) {
        int[][] array = {{2,3},
                        {1,6},
                        {8,9},
                        {7,4}};
        int rows = array.length;
        int columns = array[0].length;
        array = multiply(array);
        for (int i = 0; i < columns; i++){
            for (int j = 0; j < rows; j++){
                System.out.print(array[i][j] + "    ");
            }
            System.out.println();
        }
    }
}
