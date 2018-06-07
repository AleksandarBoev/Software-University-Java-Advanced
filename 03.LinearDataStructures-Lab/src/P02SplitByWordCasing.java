import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02SplitByWordCasing { // TODO code gives 75/100
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //,;:.!()"'\/[]
        String[] tokens = scanner.nextLine().split("[,;:.!()\"'/\\[\\]\\s\\\\]+");
        List<String> lowerCaseWords = new ArrayList<>();
        List<String> upperCaseWords = new ArrayList<>();
        List<String> mixedCaseWords = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            if ("".equals(tokens[i]))
                continue;

            if (!containsOnlyLetters(tokens[i])) { // contains something, which is NOT a letter
                mixedCaseWords.add(tokens[i]);
                continue;
            }

            if (tokens[i].equals(tokens[i].toLowerCase())) { // only lowercase
                lowerCaseWords.add(tokens[i]);
            } else if (tokens[i].equals(tokens[i].toUpperCase())) { //only uppercase
                upperCaseWords.add(tokens[i]);
            } else {                                         //has only letters, but not all are only lowercase/uppercase
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
        }
        return false;
    }

    static boolean containsOnlyLetters(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!isLetter(word.charAt(i))) {
                return false;
            }
        }

        return true;
    }

}
