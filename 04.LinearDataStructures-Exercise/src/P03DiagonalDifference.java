import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }

        System.out.println(Math.abs(primaryDiagonalSum(matrix) - secondaryDiagonalSum(matrix)));

        //main ends here
    }

    static int primaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int index = 0; index < matrix.length; index++) {
            sum += matrix[index][index];
        }
        return sum;
    }

    static int secondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int index = 0; index < matrix.length; index++) {
            sum += matrix[index][matrix.length - 1 - index];
        }
        return sum;
    }

}
