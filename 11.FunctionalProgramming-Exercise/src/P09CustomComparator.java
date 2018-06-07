import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class P09CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");

        BiPredicate<Integer, String> oddOrEven = (number, typeOfNumber) -> {
            if ("odd".equals(typeOfNumber)) {
                return Math.abs(number) % 2 == 1;
            } else {
                return Math.abs(number) % 2 == 0;
            }
        };

        Function<String[], List<Integer>> getOddElementsSorted = tokensParam -> {
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < tokensParam.length; i++) {
                Integer currentInt = Integer.parseInt(tokensParam[i]);

                if (oddOrEven.test(currentInt, "odd")) {
                    integerList.add(currentInt);
                }
            }

            Collections.sort(integerList);
            return integerList;
        };

        Function<String[], List<Integer>> getEvenElementsSorted = tokensParam -> {
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < tokensParam.length; i++) {
                Integer currentInt = Integer.parseInt(tokensParam[i]);

                if (oddOrEven.test(currentInt, "even")) {
                    integerList.add(currentInt);
                }
            }

            Collections.sort(integerList);
            return integerList;
        };

        Consumer<String[]> printResult = tokensParam -> {
            List<Integer> sortedEvenNumbers = getEvenElementsSorted.apply(tokensParam);
            List<Integer> sortedOddNumbers = getOddElementsSorted.apply(tokensParam);

            List<Integer> combined = new ArrayList<>();
            combined.addAll(sortedEvenNumbers);
            combined.addAll(sortedOddNumbers);

            combined.stream().forEach(e -> {
                System.out.print(e + " ");
            });
        };

        printResult.accept(tokens);

        //main ends here
    }
}
