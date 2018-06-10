import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P04SortStudents {
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

        listOfNames.stream()
                .sorted((names1, names2) -> {
                    int comparisonResult = names1.getValue().compareTo(names2.getValue());

                    if (comparisonResult != 0) {
                        return comparisonResult;
                    } else {
                        return names2.getKey().compareTo(names1.getKey());
                    }
                }).forEach(p -> {
            System.out.printf("%s %s%n", p.getKey(), p.getValue());
        });

        //main ends here
    }
}
