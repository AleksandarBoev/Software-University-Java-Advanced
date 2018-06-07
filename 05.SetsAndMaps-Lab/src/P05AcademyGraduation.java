import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P05AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, double[]> studentGrades = new TreeMap<>();
        DecimalFormat df = new DecimalFormat("#.#####################");

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfStudents; i++) {
            String studentName = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            studentGrades.put(studentName, grades);
        }

        for (Map.Entry<String, double[]> kvp : studentGrades.entrySet()) {
            System.out.printf("%s is graduated with %s%n", kvp.getKey(), df.format(getAverageGrade(kvp.getValue())));
        }
        //main ends here
    }

    static double getAverageGrade(double[] grades) {
        double sum = 0.0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }

        return sum / grades.length;
    }

}
