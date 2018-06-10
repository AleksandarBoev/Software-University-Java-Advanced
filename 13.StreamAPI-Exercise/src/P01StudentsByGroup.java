import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P01StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, List<Pair<String, String>>> groupsStudents = new LinkedHashMap<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int group = Integer.parseInt(tokens[2]);

            Pair<String, String> firstNameLastName = new Pair<>(firstName, lastName);

            if (!groupsStudents.containsKey(group)) {
                List<Pair<String, String>> names = new ArrayList<>();
                names.add(firstNameLastName);
                groupsStudents.put(group, names);
            } else {
                groupsStudents.get(group).add(firstNameLastName);
            }
        }

        reader.close();

        groupsStudents.entrySet().stream() // go through the kvp map
                .filter(kvp -> kvp.getKey() == 2) // remove all kvp values, which keys are not equal to '2'
                .forEach(kvp -> { // the remaining kvp's (the ones which key is equal to '2', just one kvp actually left)
                    kvp.getValue().stream() // make a second stream through the List of Pair of the remaining kvp
                            .sorted((names1, names2) -> { // sort that list
                                return names1.getKey().compareTo(names2.getKey());
                            }).forEach(name -> { // on this sorted list print some stuff
                        System.out.printf("%s %s%n", name.getKey(), name.getValue());
                    });
                });

        //main ends here
    }
}
