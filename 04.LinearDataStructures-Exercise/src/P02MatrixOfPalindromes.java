import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] palindromes = fillPalindrome(rows, cols);
        printMatrix(palindromes);

        //main ends here
    }

    static String[][] fillPalindrome(int rows, int cols) {
        String[][] palindromes = new String[rows][cols];
        char currentCharacter = 'a';
        for (int row = 0; row < palindromes.length; row++) {
            for (int col = 0; col < palindromes[row].length; col++) {
                String currentPalindrome = "" + currentCharacter + ((char)(currentCharacter + col)) + currentCharacter;
                palindromes[row][col] = currentPalindrome;
            }
            currentCharacter++;
        }
        return palindromes;
    }

    static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
