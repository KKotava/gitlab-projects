public class Spiral {

    public static int[][] spiral(int rows, int columns) {
        int[][] array = new int[rows][columns];
        int startingRow = 0;
        int finishingRow = rows - 1;
        int startingColumn = 0;
        int finishingColumn = columns - 1;
        int number = 1;
        int lastNumber = rows * columns;

        if (array == null) {
            return array;
        }

        while (number <= lastNumber) {
            for (int i = startingColumn; i <= finishingColumn; i++) {
                if (number > lastNumber) {
                    break;
                }
                array[startingRow][i] = number;
                number++;
            }
            startingRow++;

            for (int i = startingRow; i <= finishingRow; i++) {
                if (number > lastNumber) {
                    break;
                }
                array[i][finishingColumn] = number;
                number++;
            }
            finishingColumn--;

            if (startingRow <= finishingRow) {

                for (int i = finishingColumn; i >= startingColumn; i--) {
                    if (number > lastNumber) {
                        break;
                    }
                    array[finishingRow][i] = number;
                    number++;
                }
                finishingRow--;
            }

            if (startingColumn <= finishingColumn) {
                for (int i = finishingRow; i >= startingRow; i--) {
                    if (number > lastNumber) {
                        break;
                    }
                    array[i][startingColumn] = number;
                    number++;
                }
                startingColumn++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] spiral = Spiral.spiral(0, 0);
        for (int i = 0; i < spiral.length; i++) {
            for (int j = 0; j < spiral[i].length; j++) {
                System.out.print(String.format("%4s", spiral[i][j]));
            }
            System.out.println();
        }
    }
}
