import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class P03FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = reader.readLine().split("\\s+");
        String[] letters = reader.readLine().split("\\s+");

        Optional<String> name = Arrays.stream(names)
                .filter(x -> {
                    for (int i = 0; i < letters.length; i++) {
                        if ((x.toLowerCase().charAt(0) + "").equals(letters[i].toLowerCase())) {
                            return true;
                        }
                    }
                    return false;
                })
                .sorted()
                .findFirst();

        if (name.isPresent()) {
            System.out.println(name.get());
        } else {
            System.out.println("No match");
        }
        //main ends here
    }
}
