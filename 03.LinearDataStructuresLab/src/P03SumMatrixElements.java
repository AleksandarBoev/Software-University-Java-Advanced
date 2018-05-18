import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] currentTokens = scanner.nextLine().split(", ");
            int[] currentRow = new int[currentTokens.length]; // could be done via .stream -> mapToInt(Integer::parseInt).toArray

            for (int i = 0; i < currentTokens.length; i++) {
                currentRow[i] = Integer.parseInt(currentTokens[i]);
            }

            matrix[row] = currentRow;
        }

        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);

        //main ends here
    }
}
