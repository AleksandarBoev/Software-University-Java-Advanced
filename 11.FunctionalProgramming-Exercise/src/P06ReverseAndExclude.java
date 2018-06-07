import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class P06ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
        int divider = Integer.parseInt(reader.readLine());

        BiPredicate<Integer, Integer> isDivisible = (number, div) -> {
            return Math.abs(number) % div == 0;
        };

        BiFunction<int[], Integer, int[]> reverseAndRemove = (integerArray, divisor) -> {
            List<Integer> result = new ArrayList<>();
            for (int i = integerArray.length - 1; i >= 0; i--) {
                if (!isDivisible.test(integerArray[i], divisor)) {
                    result.add(integerArray[i]);
                }
            }

            int[] resultArray = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                resultArray[i] = result.get(i);
            }

            return resultArray;
        };

        numbers = reverseAndRemove.apply(numbers, divider);
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
    }
}
