import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class P06FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> nameEmailList = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

            String name = tokens[0] + " " + tokens[1];
            String phoneNumber = tokens[2];

            Pair<String, String> currentNameEmail = new Pair<>(name, phoneNumber);
            nameEmailList.add(currentNameEmail);
        }
        reader.close();

        Predicate<String> validPhoneNumber = phone -> {
            return phone.startsWith("02") || phone.startsWith("+3592");
        };

        nameEmailList.stream()
                .filter(p -> validPhoneNumber.test(p.getValue()))
                .forEach(p -> System.out.printf("%s%n", p.getKey()));


        //main ends here
    }
}
