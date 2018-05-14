import java.util.Arrays;
import java.util.Scanner;

public class P04TwoXTwoSquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        char[][] charMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                charMatrix[row][col] = scanner.next().charAt(0); // don't know how to make a stream with characters... yet
            }
            scanner.nextLine();
        }

        int count = 0;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                if (charMatrix[row][col] == charMatrix[row][col + 1] &&
                        charMatrix[row][col] == charMatrix[row + 1][col] &&
                        charMatrix[row][col] == charMatrix[row + 1][col + 1]) {
                    count++;
                }
            }
        }

        System.out.println(count);
        //main ends here
    }
}
