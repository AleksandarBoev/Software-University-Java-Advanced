import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class P08WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, int[]>> nameGradesList = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ", 3); // split by " ", and have a total of 3 strings after splitting

            String name = tokens[0] + " " + tokens[1];
            int[] grades = Arrays.stream(tokens[2].split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();

            Pair<String, int[]> currentNameGrades = new Pair<>(name, grades);
            nameGradesList.add(currentNameGrades);
        }
        reader.close();

        Predicate<int[]> atLeastTwoWeakGrades = integerArray -> {
            int count = 0;
            for (int i = 0; i < integerArray.length; i++) {
                if (integerArray[i] <= 3)
                    count++;
            }

            return count >= 2;
        };

        nameGradesList.stream()
                .filter(p -> atLeastTwoWeakGrades.test(p.getValue()))
                .forEach(p -> System.out.printf("%s%n", p.getKey()));

        //main ends here
    }
}
