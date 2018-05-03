import java.util.Arrays;
import java.util.Scanner;

public class P04MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixInfo = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixInfo[0];
        int cols = matrixInfo[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) { // po princip nqma nujda da se pravi matrica v tazi zadacha, no karai...
            int[] currentMatrixRow = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = currentMatrixRow[col];
            }
        }

        int[][] subMatrix = new int[2][2];
        int biggestSum = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (currentSum > biggestSum) {
                    subMatrix[0][0] = matrix[row][col];
                    subMatrix[0][1] = matrix[row][col + 1];
                    subMatrix[1][0] = matrix[row + 1][col];
                    subMatrix[1][1] = matrix[row + 1][col + 1];
                    biggestSum = currentSum;
                }
            }
        }

        printMatrix(subMatrix);
        System.out.println(biggestSum);

        //main ends here
    }

    static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(matrix[row][col]);
                if (col != matrix[row].length - 1) {
                    sb.append(' ');
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

}
