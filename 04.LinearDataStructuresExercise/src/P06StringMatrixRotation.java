import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputs = new ArrayList<>();
        String input;
        int longestString = 0;
        while (!"END".equals(input = scanner.nextLine())) {
            inputs.add(input);

            if (longestString < input.length()) {
                longestString = input.length();
            }
        }

        char[][] matrix = new char[inputs.size()][longestString];

        int row = 0;
        for (String currentInput : inputs) {
            int index = 0;
            for (index = 0; index < currentInput.length(); index++) {
                matrix[row][index] = currentInput.charAt(index);
            }

            for (int i = index; i < matrix[row].length; i++) {
                matrix[row][i] = ' ';
            }

            row++;
        }

        //main ends here
    }

//    static char[][] flip90(char[][] matrix) {
//
//    }
//
//    static char[][] flip180(char[][] matrix) {
//
//    }
//
//    static char[][] flip270(char[][] matrix) {
//
//    }
//
//    static char[][] flip(char[][] matrix, int degrees) {
//        //switch case
//        //degrees %= 90
//    }

}
