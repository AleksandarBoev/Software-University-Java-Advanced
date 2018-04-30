import java.util.Arrays;
import java.util.Scanner;

public class P08FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] commands = scanner.nextLine().split(" ");

        int oddEvenCount = Integer.parseInt(commands[1]);
        if (oddEvenCount == 0) {
            return;
        }
        int counter = 0;


        if (commands[2].equals("odd")) {
            for (int i = 0; i < numbers.length; i++) {
                if (Math.abs(numbers[i]) % 2 == 1) { // numbers < 0 don't operate with %
                    System.out.print(numbers[i] + " ");
                    if (++counter == oddEvenCount) {
                        break;
                    }
                }
            }
        } else if (commands[2].equals("even")) {
            for (int i = 0; i < numbers.length; i++) {
                if (Math.abs(numbers[i]) % 2 == 0) {
                    System.out.print(numbers[i] + " ");
                    if (++counter == oddEvenCount) {
                        break;
                    }
                }
            }
        }

        //main ends here
    }
}
