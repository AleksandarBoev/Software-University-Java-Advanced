import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class P03CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        Predicate<String> isUpperCase = word -> {
            return word.charAt(0) == word.toUpperCase().charAt(0);
        };

        Function<String, Integer> getUpperCaseWordsCount = text -> {
            int count = 0;

            String[] tokens = text.split(" ");
            for (String token : tokens) {
                if (isUpperCase.test(token)) {
                    count++;
                }
            }

            return count;
        };

        Function<String, List<String>> getUpperCaseWords = text -> {
            List<String> result = new ArrayList<>();

            String[] tokens = text.split(" ");
            for (String token : tokens) {
                if (isUpperCase.test(token)) {
                    result.add(token);
                }
            }

            return result;
        };

        Consumer<List<String>> printList = list -> {
            Iterator<String> iterator = list.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        };

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        reader.close();

        System.out.println(getUpperCaseWordsCount.apply(input));

        List<String> upperCaseWordsList = getUpperCaseWords.apply(input);
        printList.accept(upperCaseWordsList);

        //main ends here
    }
}
