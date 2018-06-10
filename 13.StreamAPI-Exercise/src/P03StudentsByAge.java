import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P03StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, Integer>> nameAgeList = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

            String name = tokens[0] + " " + tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Pair<String, Integer> currentNameAge = new Pair<>(name, age);
            nameAgeList.add(currentNameAge);
        }
        reader.close();

        nameAgeList.stream()
                .filter(p -> p.getValue() >= 18 && p.getValue() <= 24)
                .forEach(p -> System.out.printf("%s %d%n", p.getKey(), p.getValue()));

        //main ends here
    }
}
