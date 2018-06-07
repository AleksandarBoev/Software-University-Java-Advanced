import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P05FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfInputs = Integer.parseInt(reader.readLine());

        Map<String, Integer> nameAge = new LinkedHashMap<>();

        for (int i = 0; i < numberOfInputs; i++) {
            String[] tokens = reader.readLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            nameAge.put(name, age);
        }

        String condition = reader.readLine();
        int ageLimit = Integer.parseInt(reader.readLine());
        String printOption = reader.readLine();

        Pair<String, Integer> ageConditionLimit = new Pair<>(condition, ageLimit);

        BiPredicate<Pair<String, Integer>, Integer> isAdequateAge = (conditions, currentAge) -> {
            if ("younger".equals(conditions.getKey())) {
                return currentAge < conditions.getValue();
            } else  {
                return currentAge >= conditions.getValue();
            }
        };

        BiConsumer<String, Map.Entry<String, Integer>> printPerson = (howToPrint, person) -> {
            if ("name".equals(howToPrint)) {
                System.out.println(person.getKey());
            } else if ("age".equals(howToPrint)) {
                System.out.println(person.getValue());
            } else {
                System.out.printf("%s - %d%n", person.getKey(), person.getValue());
            }
        };

        nameAge.entrySet().stream()
                .filter(person -> isAdequateAge.test(ageConditionLimit, person.getValue()))
                .forEach(person -> printPerson.accept(printOption, person));

        //main ends here
    }
}
