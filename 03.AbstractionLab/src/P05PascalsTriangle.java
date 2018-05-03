import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class P05PascalsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        BigInteger[][] pascalMatrix = new BigInteger[rows][rows];

        for (int row = 0; row < rows; row++) {
            pascalMatrix[row][0] = BigInteger.valueOf(1);
            pascalMatrix[row][row] = BigInteger.valueOf(1);

            if (row > 1) {
                BigInteger[] upperRow = pascalMatrix[row - 1];
                for (int col = 1; col < row; col++) {
                    pascalMatrix[row][col] = upperRow[col - 1].add(upperRow[col]);
                }
            }
        }

        printPascalMatrix(pascalMatrix);

        //main ends here
    }

    static void printPascalMatrix(BigInteger[][] pascalMatrix) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < pascalMatrix.length; row++) {
            for (int col = 0; col < pascalMatrix[row].length; col++) {
                if (pascalMatrix[row][col] == null) {
                    break;
                }

                sb.append(pascalMatrix[row][col]);
                if (col != pascalMatrix[row].length - 1) {
                    sb.append(' ');
                }
            }

            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

}
