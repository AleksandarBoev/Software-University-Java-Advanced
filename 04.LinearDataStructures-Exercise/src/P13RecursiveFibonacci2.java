import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P13RecursiveFibonacci2 {
    public static void main(String[] args) throws IOException { //TODO optimize for time
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        reader.close();
        Map<Integer, Long> savedResults = new HashMap<>();//going to mimic the memoization idea behind multiple recursive calls to increase speed performance

        if (n < 1) {
            System.out.println(0);
            return;
        }
        System.out.println(getFibonacci(n + 1, savedResults));

        //main ends here
    }

    static long getFibonacci(int n, Map<Integer, Long> savedResults) {
        if (n == 1 || n == 2) {
            savedResults.putIfAbsent(n, 1L);
            return 1;
        }

        if (savedResults.containsKey(n)) {
            return savedResults.get(n);
        }
        long fibonacciOperand1 = getFibonacci(n - 1, savedResults);
        long fibonacciOperand2 = getFibonacci(n - 2, savedResults);

        savedResults.putIfAbsent(n, fibonacciOperand1 + fibonacciOperand2);

        return fibonacciOperand1 + fibonacciOperand2;
    }

}
