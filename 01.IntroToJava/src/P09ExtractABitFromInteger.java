import java.util.Scanner;

public class P09ExtractABitFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt(); // int = 32bit --> 0000 0000 0000 0000 0000 0000 0000 0000
        int positionBit = scanner.nextInt(); // shifting to the right means what it means. If any 1's go out of bounds they are lost forever
        int bit = (number >> positionBit) & 1; // 1 = 0000 0000 0000 0000 0000 0000 0000 0001
        // & returns 1 only if both positions are 1.
        System.out.println(bit);
        //main ends here
    }

}
