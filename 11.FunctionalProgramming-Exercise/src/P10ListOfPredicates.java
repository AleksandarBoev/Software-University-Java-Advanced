import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class P10ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int upperLimit = Integer.parseInt(reader.readLine());
        int[] divisors = Arrays.stream(reader.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();

        BiPredicate<Integer, int[]> isDivisible = (number, arrayOfDivisors) -> {
            for (int i = 0; i < arrayOfDivisors.length; i++) {
                if (Math.abs(number) % arrayOfDivisors[i] != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= upperLimit; i++) {
            if (isDivisible.test(i, divisors)) {
                System.out.print(i + " ");
            }
        }
        //main ends here
    }
}
