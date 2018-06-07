import java.util.Arrays;
import java.util.Scanner;

public class P05OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        if (numbers.length % 2 != 0) {
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < numbers.length - 1; i+=2) {
            System.out.print(numbers[i] + ", " + numbers[i + 1] + " -> ");
            if (numbers[i] % 2 == 0 && numbers[i + 1] % 2 == 0) {
                System.out.println("both are even");
            } else if (numbers[i] % 2 == 1 && numbers[i + 1] % 2 == 1) {
                System.out.println("both are odd");
            } else {
                System.out.println("different");
            }
        }

        //main ends here
    }
}
