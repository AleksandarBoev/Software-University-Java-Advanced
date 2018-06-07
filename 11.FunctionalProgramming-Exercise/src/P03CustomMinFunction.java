import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) throws IOException {
        Function<Integer[], Integer> getMin = integerArray -> {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < integerArray.length; i++) {
                if (integerArray[i] < min) {
                    min = integerArray[i];
                }
            }

            return min;
        };

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers = Arrays.stream(reader.readLine().split(" ")).map(x -> Integer.parseInt(x)).toArray(size -> new Integer[size]);

        reader.close();

        System.out.println(getMin.apply(numbers));

        //main ends here
    }
}
