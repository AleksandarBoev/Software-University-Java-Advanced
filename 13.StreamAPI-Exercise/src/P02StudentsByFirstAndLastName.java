import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class P02StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> listOfNames = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            Pair<String, String> currentNames = new Pair<>(tokens[0], tokens[1]);

            listOfNames.add(currentNames);
        }
        reader.close();

//        Predicate<Pair<String, String>> firstNameIsBeforeLast = pair -> { // no problem to put it in the filter
//            return pair.getKey().compareTo(pair.getValue()) < 0;
//        };

        listOfNames.stream()
                .filter(names -> names.getKey().compareTo(names.getValue()) < 0) // unexpected problem! the results are not just 0/1/-1, but are <0/=0/>0
                .forEach(p -> {
                    System.out.printf("%s %s%n", p.getKey(), p.getValue());
                });
        //main ends here
    }
}
