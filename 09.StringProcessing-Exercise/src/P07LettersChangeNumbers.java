import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P07LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");

        double sum = 0.0;
        for (int i = 0; i < tokens.length; i++) {
            sum += calculateValue(tokens[i]);
        }

        System.out.printf("%.2f", sum);
        //main ends here
    }

    static double calculateValue(String stringValue) {
        char firstLetter = stringValue.charAt(0);
        int number = Integer.parseInt(stringValue.substring(1, stringValue.length() - 1));
        char lastLetter = stringValue.charAt(stringValue.length() - 1);

        double result = 0.0;

        if (Character.isUpperCase(firstLetter)) {
            result = 1.0 * number / (firstLetter - 64); // ascii code. 'A' = 65
        } else {
            result = 1.0 * number * (firstLetter - 96); // 'a' = 97
        }

        if (Character.isUpperCase(lastLetter)) {
            result -= (lastLetter - 64);
        } else {
            result += (lastLetter - 96);
        }

        return result;
    }

}
