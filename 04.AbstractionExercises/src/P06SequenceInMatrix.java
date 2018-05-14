import java.util.Arrays;
import java.util.Scanner;

public class P06SequenceInMatrix {
    public static void main(String[] args) {
        //UNFINISHED TASK
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] stringMatrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            stringMatrix[row] = scanner.nextLine().split(" ");
        }

        String[] answer = getRepetitivePrimaryDiagonal(stringMatrix);
        System.out.println(Arrays.toString(answer));

        //main ends here
    }

    static String[] getRepetitivePrimaryDiagonal(String[][] matrix) {
        int biggestCount = 1;
        int currentCount = 1;
        String repetitiveString = matrix[0][0];

        for (int col = 0; col < matrix[0].length - 1; col++) { //poslednata iteraciq bi bila bezsmislena
            for (int row = 0; row < matrix.length; row++) {
                try {
//                    String word1 = matrix[row][col + row];
//                    String word2 = matrix[row + 1][col + row + 1];
                    if (matrix[row][col + row].equals(matrix[row + 1][col + row + 1])) {
                        currentCount++;
                        if (currentCount > biggestCount) {
                            biggestCount = currentCount;
                            repetitiveString = matrix[row][col];
                        } else {
                            currentCount = 1;
                        }
                    }
                }
                catch (Exception e) {
                    break;
                }
            }
            currentCount = 1;
        }

        String[] answer = new String[biggestCount];
        for (int index = 0; index < biggestCount; index++) {
            answer[index] = repetitiveString;
        }

        return answer;
    }

    static String[] getRepetitiveRows(String[][] matrix) {
        int biggestCount = 1;
        int currentCount = 1;
        String repetitiveString = matrix[0][0];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                if (matrix[row][col].equals(matrix[row][col + 1])) {
                    currentCount++;
                    if (currentCount > biggestCount) {
                        biggestCount = currentCount;
                        repetitiveString = matrix[row][col];
                    }
                } else {
                    currentCount = 1;
                }
            }

            currentCount = 1; // new line, new counting
        }

        String[] answer = new String[biggestCount];
        for (int index = 0; index < biggestCount; index++) {
            answer[index] = repetitiveString;
        }

        return answer;
    }

    static String[] getRepetitiveCols(String[][] matrix) {
        int biggestCount = 1;
        int currentCount = 1;
        String repetitiveString = matrix[0][0];

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length - 1; row++) {
                if (matrix[row][col].equals(matrix[row + 1][col])) {
                    currentCount++;
                    if (currentCount > biggestCount) {
                        biggestCount = currentCount;
                        repetitiveString = matrix[row][col];
                    }
                } else {
                    currentCount = 1;
                }
            }

            currentCount = 1; // new line, new counting
        }

        String[] answer = new String[biggestCount];
        for (int index = 0; index < biggestCount; index++) {
            answer[index] = repetitiveString;
        }

        return answer;
    }

}
