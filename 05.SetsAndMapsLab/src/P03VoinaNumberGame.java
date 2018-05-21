import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> playerOneCards = new LinkedHashSet<>();
        Set<Integer> playerTwoCards = new LinkedHashSet<>();

        String[] firstCards = scanner.nextLine().split(" ");
        String[] secondCards = scanner.nextLine().split(" ");

        for (int i = 0; i < firstCards.length; i++) {
            playerOneCards.add(Integer.parseInt(firstCards[i]));
        }

        for (int i = 0; i < secondCards.length; i++) {
            playerTwoCards.add(Integer.parseInt(secondCards[i]));
        }

        int round = 0;
        while (!playerOneCards.isEmpty() && !playerTwoCards.isEmpty() && round < 50) {
            int firstPlayerTopCard = playerOneCards.iterator().next();
            int secondPlayerTopCard = playerTwoCards.iterator().next();

            playerOneCards.remove(firstPlayerTopCard);
            playerTwoCards.remove(secondPlayerTopCard);

            if (firstPlayerTopCard > secondPlayerTopCard) {
                playerOneCards.add(secondPlayerTopCard);
                playerOneCards.add(firstPlayerTopCard);
            } else if (secondPlayerTopCard > firstPlayerTopCard) {
                playerTwoCards.add(firstPlayerTopCard);
                playerTwoCards.add(secondPlayerTopCard);
            }

            round++;
        }

        if (playerOneCards.size() > playerTwoCards.size()) {
            System.out.println("First player win!");
        } else if (playerTwoCards.size() > playerOneCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
        //main ends here
    }
}
