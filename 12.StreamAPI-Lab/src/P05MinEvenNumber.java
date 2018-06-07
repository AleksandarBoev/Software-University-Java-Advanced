import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class P05MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");

        OptionalDouble minElement = Arrays.stream(tokens)
                .filter(x -> x.length() > 0)
                .mapToDouble(x -> Double.parseDouble(x))
                .filter(x -> x % 2 == 0)
                .sorted()
                .findFirst();

        if (minElement.isPresent()) {
            System.out.printf("%.2f", minElement.getAsDouble());
        } else {
            System.out.println("No match");
        }
        //main ends here
    }
}
