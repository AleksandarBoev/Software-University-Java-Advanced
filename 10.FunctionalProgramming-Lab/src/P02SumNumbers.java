import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P02SumNumbers {
    public static void main(String[] args) throws IOException {
        Function<String, Integer> countNumbers = textInput -> {
            return textInput.split(", ").length;
        };

        Function<String, Integer> sumNumbers = textInput -> {
            int sum = 0;
            String[] splitText = textInput.split(", ");
            for (int i = 0; i < splitText.length; i++) {
                sum += Integer.parseInt(splitText[i]);
            }
            return sum;
        };

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        reader.close();

        System.out.printf("Count = %d%n", countNumbers.apply(input));
        System.out.printf("Sum = %d%n", sumNumbers.apply(input));

        //main ends here
    }
}
