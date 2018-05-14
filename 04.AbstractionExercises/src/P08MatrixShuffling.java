import java.util.Scanner;

public class P08MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] stringMatrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            stringMatrix[row] = currentRow;
        }

        String input = "";
        while (!(input = scanner.nextLine()).equals("END")) {
            String[] commands = input.split(" ");
            if (commands.length != 5 || !commands[0].equals("swap")) {
                System.out.println("Invalid input!");
                continue;
            }

            try {
                int row1 = Integer.parseInt(commands[1]);
                int col1 = Integer.parseInt(commands[2]);
                int row2 = Integer.parseInt(commands[3]);
                int col2 = Integer.parseInt(commands[4]);

                String firstString = stringMatrix[row1][col1];
                String secondString = stringMatrix[row2][col2];

                stringMatrix[row2][col2] = firstString;
                stringMatrix[row1][col1] = secondString;

                printMatrix(stringMatrix);
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
        //main ends here
    }

    static void printMatrix(String[][] stringMatrix) {
        for (int row = 0; row < stringMatrix.length; row++) {
            for (int col = 0; col < stringMatrix[row].length; col++) {
                System.out.print(stringMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
