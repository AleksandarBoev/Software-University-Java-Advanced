import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer>  orderedCharacterCount = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (!orderedCharacterCount.containsKey(input.charAt(i))) {
                orderedCharacterCount.put(input.charAt(i), 0);
            }

            orderedCharacterCount.put(input.charAt(i), orderedCharacterCount.get(input.charAt(i)) + 1);
        }

        for (Character currentChar : orderedCharacterCount.keySet()) {
            System.out.printf("%c: %d time/s%n", currentChar, orderedCharacterCount.get(currentChar));
        }

        //main ends here
    }
}
