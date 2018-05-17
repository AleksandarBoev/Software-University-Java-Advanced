import java.math.BigInteger;
import java.util.Scanner;

public class P07ProductOfNumbersNtoM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int counter = num1;
        BigInteger result = new BigInteger("1");

        do {
            result = result.multiply(BigInteger.valueOf(counter));
        } while (counter++ < num2);

        System.out.printf("product[%d..%d] = %s", num1, num2, result.toString());

        //main ends here
    }
}
