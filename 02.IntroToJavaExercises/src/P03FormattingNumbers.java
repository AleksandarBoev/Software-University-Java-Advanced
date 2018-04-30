import java.util.Scanner;

public class P03FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int intNumber = Integer.parseInt(input[0]);
        double doubleNumber1 = Double.parseDouble(input[1]);
        double doubleNumber2 = Double.parseDouble(input[2]);

        String hexadecimal = Integer.toHexString(intNumber);
        String binary = String.format("%10s", Integer.toBinaryString(intNumber)).replace(' ', '0');
        String doubleNumber1WithTwoDigits = String.format("%.2f", doubleNumber1);
        String doubleNumber2WithThreeDigits = String.format("%.3f", doubleNumber2);

        System.out.printf("|%-10s|%s|%10s|%-10s|", hexadecimal.toUpperCase(), binary, doubleNumber1WithTwoDigits, doubleNumber2WithThreeDigits);
        //main ends here
    }
}
