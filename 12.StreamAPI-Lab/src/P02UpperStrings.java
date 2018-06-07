import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");

        Arrays.stream(tokens)
                .map(x -> x.toUpperCase())
                .forEach(x -> {
            System.out.print(x + " ");
        });

        //main ends here
    }
}
