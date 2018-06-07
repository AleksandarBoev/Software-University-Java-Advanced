import java.util.Scanner;

public class P06HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte target = 0;
        try {
            target = Byte.parseByte(scanner.nextLine());
        } catch (Exception e) {
            return;
        }
        if (target > 40 || target < -20) {
            return;
        }

        for (int i = 1; i <= 20; i++) {
            if (i >= target) {
                break;
            }

            for (int j = 1; j <= 20; j++) {
                if (i + j == target) {
                    System.out.printf("%d + %d = %d%n", i, j, target);
                    break;
                }
            }
        }

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i - j == target) {
                    System.out.printf("%d - %d = %d%n", i, j, target);
                    break;
                }
            }
        }



        //main ends here
    }
}
