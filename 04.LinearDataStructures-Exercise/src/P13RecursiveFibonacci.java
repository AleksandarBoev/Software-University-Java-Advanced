import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P13RecursiveFibonacci {
    public static void main(String[] args) throws IOException { //TODO optimize for time
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        reader.close();

        if (n < 1) {
            System.out.println(0);
            return;
        }
        System.out.println(getFibonacci(n + 1));

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

}
