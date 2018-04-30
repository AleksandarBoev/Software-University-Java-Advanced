import java.util.Scanner;

public class P08Lottery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int n1 = 1; n1 <= 8; n1++) {
            for (int n2 = n1 + 1; n2 <= 9; n2++) {
                for (int n3 = n2 + 1; n3 <= 10; n3++) {
                    System.out.println(n1 + " " + n2 + " " + n3);
                }
            }
        }
    }
}
