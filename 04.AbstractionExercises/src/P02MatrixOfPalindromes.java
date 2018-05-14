import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] palindromesMatrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            char currentChar = (char)(97 + row);
            for (int col = 0; col < cols; col++) {
                palindromesMatrix[row][col] = "" + currentChar + (char)(currentChar + col) + currentChar;
            }
        }

        printMatrix(palindromesMatrix);
        //main ends here
    }

    static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
