import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class P09StudentsByEnrollmentYear {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> facultyNumberGrades = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ", 2);

            String facultyNumber = tokens[0];
            String grades = tokens[1];

            Pair<String, String> currentFacultyNumberGrades = new Pair<>(facultyNumber, grades);
            facultyNumberGrades.add(currentFacultyNumberGrades);
        }
        reader.close();

        facultyNumberGrades.stream()
                .filter(p -> p.getKey().endsWith("14") || p.getKey().endsWith("15"))
                .forEach(p -> System.out.printf("%s%n", p.getValue()));

        //main ends here
    }
}
