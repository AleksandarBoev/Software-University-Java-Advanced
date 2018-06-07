import java.util.ArrayDeque;
import java.util.Scanner;

public class P06DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());
        if (decimalNumber == 0) {
            System.out.println(0);
            return;
        }
        ArrayDeque <Integer> binaryNumber = new ArrayDeque<>();

        while (decimalNumber != 0) {
            Integer remainder = decimalNumber % 2;
            binaryNumber.push(remainder);
            decimalNumber /= 2;
        }

        while (binaryNumber.size() != 0) {
            System.out.print(binaryNumber.pop());
        }
        //main ends here
    }
}
