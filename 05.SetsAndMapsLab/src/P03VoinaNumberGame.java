import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> playerOneCards = new LinkedHashSet<>();
        Set<Integer> playerTwoCards = new LinkedHashSet<>();

        String[] firstCards = scanner.next().split(" ");
        String[] secondCards = scanner.next().split(" ");

        for (int i = 0; i < firstCards.length; i++) {
            playerOneCards.add(Integer.parseInt(firstCards[i]));
        }

        for (int i = 0; i < secondCards.length; i++) {
            playerTwoCards.add(Integer.parseInt(secondCards[i]));
        }

        int round = 0;
        while (!playerOneCards.isEmpty() && !playerTwoCards.isEmpty() && round < 50) {
//            int firstPlayerCard = firstCards.

            round++;
        }
        //main ends here
    }
}
