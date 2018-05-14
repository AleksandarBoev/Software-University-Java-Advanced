import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int rowsAndCols = Integer.parseInt(tokens[0]);
        char fillMethod = tokens[1].charAt(0);

        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        if (fillMethod == 'A') {
            fillMethodA(matrix);
        } else {
            fillMethodB(matrix);
        }
        printMatrix(matrix);
        //main ends here
    }

    static void fillMethodA(int[][] matrix) {
        int row = 0;
        int counter = 1;
        for (int col = 0; col < matrix[row].length; col++) { // purvo po stulbove shte se obhojda
            row = 0;
            for (row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter++;
            }
            row--; // inache matrix[row].length shte grumne, "Array index out of bounds"
        }
    }

    static void fillMethodB(int[][] matrix) {
        int row = 0;
        int counter = 1;
        for (int col = 0; col < matrix[row].length; col++) { // purvo po stulbove shte se obhojda
            row = 0;
            if (col % 2 == 0) {
                for (row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter++;
                }
                row--; // inache matrix[row].length shte grumne, "Array index out of bounds"
            } else {
                for (row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter++;
                }
                row++;
            }
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
