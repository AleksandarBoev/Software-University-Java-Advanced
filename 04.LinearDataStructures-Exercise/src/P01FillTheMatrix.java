import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(tokens[0]);
        int[][] matrix = new int[matrixSize][matrixSize];
        char method = tokens[1].charAt(0);

        if (method == 'A') {
            methodAFill(matrix);
        } else if (method == 'B') {
            methodBFill(matrix);
        }

        printMatrix(matrix);
        //main ends here
    }

    static void methodBFill(int[][] matrix) {
        int counter = 1;

        for (int col = 0; col < matrix[0].length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix[0].length; row++) {
                    matrix[row][col] = counter++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter++;
                }
            }
        }
    }

    static void methodAFill(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix[0].length; row++) {
                matrix[row][col] = counter++;
            }
        }
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
