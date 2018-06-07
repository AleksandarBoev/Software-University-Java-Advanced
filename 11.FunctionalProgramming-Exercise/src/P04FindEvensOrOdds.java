import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.function.BiPredicate;

public class P04FindEvensOrOdds {
    public static void main(String[] args) throws IOException { // looks like a stupid solution, but the instructions of the task specify it
        BiPredicate<Integer, String> oddOrEven = (number, typeOfNumber) -> {
            if ("odd".equals(typeOfNumber)) {
                return number % 2 == 1;
            } else {
                return number % 2 == 0;
            }
        };

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] limits = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(x -> Integer.parseInt(x))
                .toArray();

        String typeOfNumber = reader.readLine();

        printNumbers(Math.min(limits[0], limits[1]), Math.max(limits[0], limits[1]), typeOfNumber, oddOrEven);

        //main ends here
    }

    static void printNumbers(int lowerLimit, int upperLimit, String typeOfNumber, BiPredicate<Integer, String> oddOrEven) {
        for (int i = lowerLimit; i <= upperLimit; i++) {
            if (oddOrEven.test(i, typeOfNumber)) {
                System.out.print(i + " ");
            }
        }
    }

}
