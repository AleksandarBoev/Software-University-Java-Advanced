import java.util.Scanner;

public class P01CalculateTriangleAreaMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double base = scanner.nextDouble();
        double height = scanner.nextDouble();
        scanner.nextLine();

        System.out.printf("Area = %.2f", calculateArea(base, height));
        //main ends here
    }

    static double calculateArea(double base, double height) {
        return (base * height) / 2.0;
    }

}
