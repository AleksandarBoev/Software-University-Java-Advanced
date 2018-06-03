import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01StudentsResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("(, | - )");

        String studentName = tokens[0];
        double jAdvMark = Double.parseDouble(tokens[1]);
        double jOopMark = Double.parseDouble(tokens[2]);
        double jOopAdvMark = Double.parseDouble(tokens[3]);
        double averageMark = (jAdvMark + jOopMark + jOopAdvMark) / 3.0;

        System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", studentName, jAdvMark, jOopMark, jOopAdvMark, averageMark);

        //main ends here
    }
}

