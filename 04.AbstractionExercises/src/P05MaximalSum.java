import java.util.Arrays;
import java.util.Scanner;

public class P05MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[rows][cols];

        int biggestSum = Integer.MIN_VALUE;
        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }

        int[][] biggestSumMatrix = getBiggestSumSubmatrix(matrix, 3);

        System.out.printf("Sum = %d%n", getMatrixSum(biggestSumMatrix));
        printMatrix(biggestSumMatrix);
        //main ends here
    }

    static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    static int[][] getBiggestSumSubmatrix(int[][] matrix, int submatrixSize) { // a method should do only 1 thing...
        int rows = matrix.length;
        int cols = matrix[0].length;
        int biggestSum = Integer.MIN_VALUE;
        int[][] biggestSumMatrix = new int[submatrixSize][submatrixSize];

        for (int row = 0; row < rows - (submatrixSize - 1); row++) {
            for (int col = 0; col < cols - (submatrixSize - 1); col++) {
                int currentSum = 0;
                for (int i = 0; i < Math.pow(submatrixSize, 2); i++) {
                    currentSum += matrix[row + (i / submatrixSize)][col + (i % submatrixSize)];
                }

                if (currentSum > biggestSum) {
                    for (int i = 0; i < 9; i++) {
                        biggestSumMatrix[i / submatrixSize][i % submatrixSize] = matrix[row + (i / submatrixSize)][col + (i % submatrixSize)];
                    }
                    biggestSum = currentSum;
                }
            }
        }

        return biggestSumMatrix;
    }

    static int getMatrixSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

}
