import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class P11PredicateParty {
    public static void main(String[] args) throws IOException { //TODO think of a smarter way of doing this
        BiConsumer<String, List<String>> removeEndsWith = (stringEnding, listOfStrings) -> {
            for (int i = 0; i < listOfStrings.size(); i++) {
                if (listOfStrings.get(i).endsWith(stringEnding)) {
                    listOfStrings.remove(i);
                    i--;
                }
            }
        };

        BiConsumer<String, List<String>> removeStartsWith = (stringStart, listOfStrings) -> {
            for (int i = 0; i < listOfStrings.size(); i++) {
                if (listOfStrings.get(i).startsWith(stringStart)) {
                    listOfStrings.remove(i);
                    i--;
                }
            }
        };

        BiConsumer<String, List<String>> doubleEndsWith = (stringEnding, listOfStrings) -> {
            for (int i = 0; i < listOfStrings.size(); i++) {
                if (listOfStrings.get(i).endsWith(stringEnding)) {
                    listOfStrings.add(i, listOfStrings.get(i));
                    i++;
                }
            }
        };

        BiConsumer<String, List<String>> doubleStartsWith = (stringStart, listOfStrings) -> {
            for (int i = 0; i < listOfStrings.size(); i++) {
                if (listOfStrings.get(i).startsWith(stringStart)) {
                    listOfStrings.add(i, listOfStrings.get(i));
                    i++;
                }
            }
        };

        BiConsumer<Integer, List<String>> removeWithLength = (length, listOfStrings) -> {
            for (int i = 0; i < listOfStrings.size(); i++) {
                if (listOfStrings.get(i).length() == length) {
                    listOfStrings.remove(i);
                    i--;
                }
            }
        };

        BiConsumer<Integer, List<String>> doubleWithLength = (length, listOfStrings) -> {
            for (int i = 0; i < listOfStrings.size(); i++) {
                if (listOfStrings.get(i).length() == length) {
                    listOfStrings.add(i, listOfStrings.get(i));
                    i++;
                }
            }
        };

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>(Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toList()));

        String input = reader.readLine();
        while (!"Party!".equals(input)) {
            String[] tokens = input.split(" ");
            String command1 = tokens[0];
            String command2 = tokens[1];
            String command3 = tokens[2];

            if ("Remove".equals(command1)) {
                if ("EndsWith".equals(command2)) {
                    removeEndsWith.accept(command3, names);
                } else if ("StartsWith".equals(command2)) {
                    removeStartsWith.accept(command3, names);
                } else {
                    removeWithLength.accept(Integer.parseInt(command3), names);
                }
            } else if ("Double".equals(command1)) {
                if ("EndsWith".equals(command2)) {
                    doubleEndsWith.accept(command3, names);
                } else if ("StartsWith".equals(command2)) {
                    doubleStartsWith.accept(command3, names);
                } else {
                    doubleWithLength.accept(Integer.parseInt(command3), names);
                }
            }

            input = reader.readLine();
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.printf("%s are going to the party!", names.toString().replaceAll("[\\[\\]]", ""));
        }

        //main ends here
    }
}
