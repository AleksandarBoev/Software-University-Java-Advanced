package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        int currentRow = 0;
        int currentCol = 0;
        int[][] matrix = {{1, 2, 3}, {3, 4, 5}, {6, 7, 8}};
	    while (true) {
            System.out.print("Command: ");
            char command = scanner.nextLine().charAt(0);
            try {
                switch (command) {
                    case 'V':
                        System.out.println(matrix[currentRow + 1][currentCol]);
                        currentRow++;
                        break;

                    case '^':
                        System.out.println(matrix[currentRow - 1][currentCol]);
                        currentRow--;
                        break;

                    case '<':
                        System.out.println(matrix[currentRow][currentCol - 1]);
                        currentCol--;
                        break;

                    case '>':
                        System.out.println(matrix[currentRow][currentCol + 1]);
                        currentCol--;
                        break;

                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.printf("Error occurred! Current row = %d, Current col = %d%n", currentRow, currentCol);
            }
        }


    }
}
