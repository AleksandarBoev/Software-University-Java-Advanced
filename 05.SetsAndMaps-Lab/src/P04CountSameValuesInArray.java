import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountSameValuesInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> doubleCount = new HashMap<>();

        String[] tokens = scanner.nextLine().split(" ");

        for (int i = 0; i < tokens.length; i++) {
            String currentKey = tokens[i];

            if (!doubleCount.containsKey(currentKey)) {
                doubleCount.put(currentKey, 0);
            }

            doubleCount.put(currentKey, doubleCount.get(currentKey) + 1);
        }

        for (String currentKey : doubleCount.keySet()) {
            System.out.printf("%s - %s times%n", currentKey, doubleCount.get(currentKey));
        }
        //main ends here
    }
}
