import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class P04AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");

        OptionalDouble average = Arrays.stream(tokens)
                .filter(x -> x.length() > 0)
                .mapToDouble(x -> Double.parseDouble(x))
                .average();

        if (average.isPresent()) {
            System.out.printf("%.2f", average.getAsDouble());
        } else {
            System.out.println("No match");
        }

        //main ends here
    }
}
