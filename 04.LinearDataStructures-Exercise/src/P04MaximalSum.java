import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
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
        int bounds = submatrixSize - 1;

        for (int row = 0; row < matrix.length - bounds; row++) {
            for (int col = 0; col < matrix[0].length - bounds; col++) {
                int[][] temporaryMatrix = new int[submatrixSize][submatrixSize];
                for (int row1 = 0; row1 < temporaryMatrix.length; row1++) { // filling a temporary matrix with the values of the original big matrix
                    for (int col1 = 0; col1 < temporaryMatrix[0].length; col1++) {
                        temporaryMatrix[row1][col1] = matrix[row + row1][col + col1];
                    }
                }

                int currentSum = sumMatrix(temporaryMatrix);
                if (currentSum > biggestSum) {
                    biggestSum = currentSum;
                    biggestSumSubmatrix = temporaryMatrix;
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