import java.util.Scanner;

public class P02AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberFormat = "[0-9]+\\.*[0-9]*";
        double num1 = Double.parseDouble(scanner.next(numberFormat));
        double num2 = Double.parseDouble(scanner.next(numberFormat));
        double num3 = Double.parseDouble(scanner.next(numberFormat));

        String answer = String.format("%.2f", (num1 + num2 + num3) / 3);
        System.out.println(answer);
        //main ends here
    }
}
