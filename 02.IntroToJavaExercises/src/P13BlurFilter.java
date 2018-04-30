import java.util.Arrays;
import java.util.Scanner;

public class P13BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blurAmount = Integer.parseInt(scanner.nextLine());
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        long[][] matrix = new long[rows][columns];
        scanner.nextLine();

        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = currentRow[col];
            }
        }

        int targetRow = scanner.nextInt();
        int targetCol = scanner.nextInt();

        for (int row = targetRow - 1; row <= targetRow + 1; row++) { // obhojda redut i negovite dva suseda
            for (int col = targetCol - 1; col <= targetCol + 1; col++) {
                try {
                    matrix[row][col] += blurAmount;
                }
                catch (Exception e) {

                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        //main ends here
    }
}
