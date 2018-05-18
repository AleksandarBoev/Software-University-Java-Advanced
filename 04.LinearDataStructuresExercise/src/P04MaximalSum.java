import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum { //TODO fix this
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][]matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] result = biggestSumSubmatrix(matrix, 3);
        System.out.println("Sum = " + sumMatrix(result));
        printMatrix(result);

        //main ends here
    }

    static int[][] biggestSumSubmatrix(int[][] matrix, int submatrixSize) {
        int biggestSum = Integer.MIN_VALUE;

        int[][] biggestSumSubmatrix = new int[submatrixSize][submatrixSize];

        for (int row = 0; row < matrix.length - submatrixSize; row++) { // matrix.length - 2
            for (int col = 0; col < matrix[0].length - submatrixSize; col++) { // matrix[0].length - 2
                int currentSum = 0;
                for (int i = row; i < row + submatrixSize - 1; i++) { // 0, 0 + 3 == 3, 3 (bez nego)
                    for (int j = col; j < col + submatrixSize - 1; j++) {
                        currentSum += matrix[i][j];
                    }
                }

                if (currentSum > biggestSum) {
                    for (int i = 0; i < biggestSumSubmatrix.length; i++) {
                        for (int j = 0; j < biggestSumSubmatrix.length; j++) {
                            biggestSumSubmatrix[i][j] = matrix[row + i][row + j];
                        }
                    }
                }
            }
        }

        return biggestSumSubmatrix;
    }

    static int sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
