import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P05FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> nameEmailList = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

            String name = tokens[0] + " " + tokens[1];
            String email = tokens[2];

            Pair<String, String> currentNameEmail = new Pair<>(name, email);
            nameEmailList.add(currentNameEmail);
        }
        reader.close();

        nameEmailList.stream()
                .filter(p -> p.getValue().endsWith("@gmail.com"))
                .forEach(p -> System.out.printf("%s%n", p.getKey()));

        //main ends here
    }
}
