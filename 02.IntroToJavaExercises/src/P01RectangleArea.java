import java.util.Scanner;

public class P01RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();

        System.out.printf("%.2f", side1 * side2);
        //maine ends here
    }
}
