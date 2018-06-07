import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");

        Arrays.stream(tokens)
                .distinct()
                .mapToInt(x -> Integer.parseInt(x))
                .filter(x -> x >= 10 && x <= 20)
                .limit(2)
                .forEach(x -> {
                    System.out.print(x + " ");
                });

        //main ends here
    }
}
