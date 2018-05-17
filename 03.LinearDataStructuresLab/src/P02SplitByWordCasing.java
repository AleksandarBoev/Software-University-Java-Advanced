import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02SplitByWordCasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //,;:.!()"'\/[]
        String[] tokens = scanner.nextLine().split("[,;:.!()\"'\\/\\[\\] ]+"); //wtf
        List<String> lowerCaseWords = new ArrayList<>();
        List<String> upperCaseWords = new ArrayList<>();
        List<String> mixedCaseWords = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            if (!containsOnlyLetters(tokens[i])) {
                mixedCaseWords.add(tokens[i]);
                continue;
            }

            if (tokens[i].equals(tokens[i].toLowerCase())) {
                lowerCaseWords.add(tokens[i]);
            } else if (tokens[i].equals(tokens[i].toUpperCase())) {
                upperCaseWords.add(tokens[i]);
            } else {
                mixedCaseWords.add(tokens[i]);
            }
        }

        System.out.printf("Lower-case: %s%n", String.join(", ", lowerCaseWords));
        System.out.printf("Mixed-case: %s%n", String.join(", ", mixedCaseWords));
        System.out.printf("Upper-case: %s", String.join(", ", upperCaseWords));


        //main ends here
    }

    static boolean isLetter(char character) {
        if (character >= 65 && character <= 90 || character >= 97 && character <= 122) {
            return true;
        } else {
            return false;
        }
    }

    static boolean containsOnlyLetters(String word) {
        for (char c = 0; c < word.length(); c++) {
            if (!isLetter(c)) {
                return false;
            }
        }

        return true;
    }

}
