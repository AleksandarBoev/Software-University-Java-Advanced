import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class P07PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maxNameLength = Integer.parseInt(reader.readLine());

        BiPredicate<String, Integer> checkName = (name, length) -> {
            return name.length() <= length;
        };

        BiConsumer<String, Integer> printRightNames = (input, length) -> {
            String[] names = input.split(" ");
            for (int i = 0; i < names.length; i++) {
                if (checkName.test(names[i], length)) {
                    System.out.println(names[i]);
                }
            }
        };


        printRightNames.accept(reader.readLine(), maxNameLength);
        //main ends here
    }
}
