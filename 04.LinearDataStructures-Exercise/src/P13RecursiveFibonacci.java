import java.util.Scanner;

public class P13RecursiveFibonacci {
    public static void main(String[] args) { //TODO optimize for time
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        if (n < 1) {
            System.out.println(0);
            return;
        }
        System.out.println(getFibonacci(n + 1));
        System.out.println(getFibonacciFaster(n));

        //main ends here
    }

    static int getFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int fibonacciOperand1 = getFibonacci(n - 1);
        int fibonacciOperand2 = getFibonacci(n - 2);
        return fibonacciOperand1 + fibonacciOperand2;
    }

    static int getFibonacciFaster(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return (getFibonacciFaster(n - 1) + getFibonacciFaster(n - 2)) * n;
    }

}
