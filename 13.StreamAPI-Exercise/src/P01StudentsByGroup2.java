import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P01StudentsByGroup2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            Student currentStudent = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            students.add(currentStudent);
        }

        reader.close();

        students.stream()
                .filter(s -> s.getGroup() == 2)
                .sorted((s1, s2) -> {
                    return s1.getFirstName().compareTo(s2.getFirstName()); // 1, 0, -1 -> first is bigger, equal, second is bigger
                    //if 1 then put s2 before s1. If -1, put s1 before s2, else leave them be
                })
                .forEach(s -> {
                    System.out.println(s.toString());
                });
        //main ends here
    }
}

class Student {
    private String firstName;
    private String lastName;
    private int group;

    public Student(String firstName, String lastName, int group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
