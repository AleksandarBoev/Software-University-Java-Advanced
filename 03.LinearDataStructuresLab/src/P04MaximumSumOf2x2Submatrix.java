import java.util.Scanner;

public class P04MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] currentTokens = scanner.nextLine().split(", ");
            int[] currentRow = new int[currentTokens.length];

            for (int i = 0; i < currentTokens.length; i++) {
                currentRow[i] = Integer.parseInt(currentTokens[i]);
            }

            matrix[row] = currentRow;
        }

        int biggestSum = Integer.MIN_VALUE;
        int[][] biggestSumSubmatrix = new int[2][2];
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (currentSum > biggestSum) {
                    biggestSum = currentSum;
                    biggestSumSubmatrix[0][0] = matrix[row][col];
                    biggestSumSubmatrix[0][1] = matrix[row][col + 1];
                    biggestSumSubmatrix[1][0] = matrix[row + 1][col];
                    biggestSumSubmatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        printMatrix(biggestSumSubmatrix);
        System.out.println(biggestSum);

        //main ends here
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
