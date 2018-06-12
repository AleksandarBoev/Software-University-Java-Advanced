import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int foodCount = 0;
        int snakeLength = 1;
        int currentRowCoordinate = 0;
        int currentColCoordinate = 0;

        int matrixSize = Integer.parseInt(reader.readLine());
        char[][] matrix = new char[matrixSize][matrixSize];

        String[] commands = reader.readLine().split(", ");

        for (int row = 0; row < matrix.length; row++) {
            String[] characters = reader.readLine().split(" ");

            for (int col = 0; col < characters.length; col++) {
                matrix[row][col] = characters[col].charAt(0);
                if (characters[col].charAt(0) == 's') {
                    currentRowCoordinate = row;
                    currentColCoordinate = col;
                } else if (characters[col].charAt(0) == 'f') {
                    foodCount++;
                }
            }
        }

        int foodEaten = 0;

//        while (foodCount > 0 && snakeIsAlive && counter != commands.length) {
        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            int[] newCoordinates = getNewRowAndCol(currentRowCoordinate, currentColCoordinate, currentCommand, matrixSize);

            currentRowCoordinate = newCoordinates[0];
            currentColCoordinate = newCoordinates[1];

            char positionItem = matrix[currentRowCoordinate][currentColCoordinate];

            switch (positionItem) {
                case 'e':
                    System.out.println("You lose! Killed by an enemy!");
                    return;
                    //break; --> unreachable statement problem. I don't need the break anyway in this situation

                case 'f':
                    foodEaten++;
                    if (foodEaten == foodCount) {
                        System.out.printf("You win! Final snake length is %d", snakeLength + foodEaten);
                        return;
                    }
                    break;

                    default: //'s' and '*' do nothing
                        break;
            }
        }

        System.out.printf("You lose! There is still %d food to be eaten.", foodCount - foodEaten);


        reader.close();
        //main ends here
    }

    static int[] getNewRowAndCol(int currentRow, int currentCol, String command, int matrixSize) {
        int[] resultRowCol = new int[2];

        switch (command) { //up / left / right / down
            case "left":
                resultRowCol[0] = currentRow;
                resultRowCol[1] = currentCol - 1;
                break;

            case "right":
                resultRowCol[0] = currentRow;
                resultRowCol[1] = currentCol + 1;
                break;

            case "up":
                resultRowCol[0] = currentRow - 1;
                resultRowCol[1] = currentCol;
                break;

            case "down":
                resultRowCol[0] = currentRow + 1;
                resultRowCol[1] = currentCol;
                break;
        }

        if (resultRowCol[1] < 0) {
            resultRowCol[1] = matrixSize - 1;
        }

        if (resultRowCol[1] > matrixSize - 1) {
            resultRowCol[1] = 0;
        }

        if (resultRowCol[0] < 0) {
            resultRowCol[0] = matrixSize - 1;
        }

        if (resultRowCol[0] > matrixSize - 1) {
            resultRowCol[0] = 0;
        }

        return resultRowCol;
    }

}
