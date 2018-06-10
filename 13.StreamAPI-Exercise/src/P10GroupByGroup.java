import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P10GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> nameGroupList = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

            String name = tokens[0] + " " + tokens[1];
            int group = Integer.parseInt(tokens[2]);

            Person currentPerson = new Person(name, group);
            nameGroupList.add(currentPerson);
        }
        reader.close();

        nameGroupList.stream()
                .collect(Collectors.groupingBy(n -> n.getGroup()))
                .forEach((group, peopleInGroup) -> {
                    System.out.println(group + " - " + peopleInGroup.toString().replaceAll("[\\[\\]]", ""));
                });

        //main ends here
    }
}

class Person {
    private String name;
    private int group;

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return getName();
    }
}
