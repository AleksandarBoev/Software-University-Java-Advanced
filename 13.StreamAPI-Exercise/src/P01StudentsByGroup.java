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

//        groupsStudents.entrySet().stream()
//                .filter(s -> s.getKey() == 2)
//                .sorted()

        //main ends here
    }
}
