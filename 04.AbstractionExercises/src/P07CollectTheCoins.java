import java.util.Scanner;

public class P07CollectTheCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] gameBoard = new String[4];
        for (int row = 0; row < 4; row++) {
            gameBoard[row] = scanner.nextLine();
        }

        String commands = scanner.nextLine();
        int wallHits = 0;
        int coinsCollected = 0;
        int currentRow = 0;
        int currentCol = 0;

        for (int command = 0; command < commands.length(); command++) {
            try {
                char currentChar = ' ';
                switch (commands.charAt(command)) {
                    case 'V':
                        currentChar = gameBoard[currentRow + 1].charAt(currentCol);
                        currentRow++; //ako gornoto grumne, tazi iteraciq nqma da bude izpulnena
                        break;

                    case '^':
                        currentChar = gameBoard[currentRow - 1].charAt(currentCol);
                        currentRow--;
                        break;

                    case '<':
                        currentChar = gameBoard[currentRow].charAt(currentCol - 1);
                        currentCol--;
                        break;

                    case '>':
                        currentChar = gameBoard[currentRow].charAt(currentCol + 1);
                        currentCol++;
                        break;

                    default:
                        break;
                }

                if (currentChar == '$') {
                    coinsCollected++;
                }
            } catch (Exception e) {
                wallHits++;
            }
        }

        System.out.printf("Coins = %d%n", coinsCollected);
        System.out.printf("Walls = %d", wallHits);
        //main ends here
    }
}
