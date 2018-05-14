import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(Math.abs(getPrimaryDiagonalSum(matrix) - getSecondaryDiagonalSum(matrix)));
        //main ends here
    }

    static int getPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int rowAndCol = 0; rowAndCol < matrix.length; rowAndCol++) {
            sum += matrix[rowAndCol][rowAndCol];
        }

        return sum;
    }

    static int getSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;

        int col = matrix.length - 1;
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[col - i][row + i];
        }

        return sum;
    }

}
