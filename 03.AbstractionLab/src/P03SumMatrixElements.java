import java.util.Arrays;
import java.util.Scanner;

public class P03SumMatrixElements {
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

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(getMatrixSum(matrix));

        //main ends here
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
