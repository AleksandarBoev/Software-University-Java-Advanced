import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P08FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        Function<String, int[]> parseNumbers = input -> {
            return Arrays.stream(input.split("\\s+")).mapToInt(x -> Integer.parseInt(x)).toArray();
        };

        Function<int[], Integer> getSmallestRighmostNumIndex = array -> {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < array.length; i++) {
                if (array[i] <= min) {
                    min = array[i];
                    minIndex = i;
                }
            }

            return minIndex;
        };

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] integerArray = parseNumbers.apply(reader.readLine());
        System.out.println(getSmallestRighmostNumIndex.apply(integerArray));
        //main ends here
    }
}
