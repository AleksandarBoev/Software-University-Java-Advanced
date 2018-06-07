import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

public class P08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playerCards = new LinkedHashMap<>();

        String input;
        while (!"JOKER".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(": ");

            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            Set<String> uniqueCards = new HashSet<>();

            Collections.addAll(uniqueCards, cards);
            if (!playerCards.containsKey(name)) {
                playerCards.put(name, uniqueCards); // kak se slaga prazen set?
            } else {
                uniqueCards.addAll(playerCards.get(name));
                playerCards.put(name, uniqueCards);
            }

        }

        for (Map.Entry<String, Set<String>> kvp : playerCards.entrySet()) {
            int totalPoints = getTotalPoints(kvp.getValue());
            System.out.printf("%s: %d%n", kvp.getKey(), totalPoints);
        }

        //main ends here
    }

    static int calculateValue(String card) {
        char cardType = card.charAt(card.length() - 1);
        int multiplier = 0;

        switch (cardType) {
            case 'S':
                multiplier = 4;
                break;

            case 'H':
                multiplier = 3;
                break;

            case 'D':
                multiplier = 2;
                break;

            case 'C':
                multiplier = 1;
                break;
        }

        card = card.replace("" + cardType, "");

        int value = 0;
        try {
            value = Integer.parseInt(card);
        } catch (NumberFormatException nfe) { // J Q K A
            if ("J".equals(card)) {
                value = 11;
            } else if ("Q".equals(card)) {
                value = 12;
            } else if ("K".equals(card)) {
                value = 13;
            } else {
                value = 14;
            }
        }

        return value * multiplier;
    }

    static int getTotalPoints(Set<String> cards) {
        int sum = 0;
        for (String card : cards) {
            sum += calculateValue(card);
        }
        return sum;
    }

}
