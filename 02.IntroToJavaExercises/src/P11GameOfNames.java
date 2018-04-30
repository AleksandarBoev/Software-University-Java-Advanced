import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P11GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> playerPoints = new LinkedHashMap<>();
        int numberOfPLayers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPLayers; i++) {
            String currentName = scanner.nextLine();
            int startingPoints = Integer.parseInt(scanner.nextLine());
            playerPoints.put(currentName, startingPoints);
        }

        int maxPoints = Integer.MIN_VALUE;
        String winner = "";
        for (String currentPlayer : playerPoints.keySet()) {
            int bonusPoints = 0;
            for (int i = 0; i < currentPlayer.length(); i++) {
                char currentChar = currentPlayer.charAt(i);

                if (currentChar % 2 == 0) {
                    bonusPoints += currentChar;
                } else {
                    bonusPoints -= currentChar;
                }
            }
            playerPoints.put(currentPlayer, playerPoints.get(currentPlayer) + bonusPoints);
            if (playerPoints.get(currentPlayer) > maxPoints) {
                winner = currentPlayer;
                maxPoints = playerPoints.get(currentPlayer);
            }
        }

        System.out.printf("The winner is %s - %d points", winner, playerPoints.get(winner));

        //main ends here
    }
}
