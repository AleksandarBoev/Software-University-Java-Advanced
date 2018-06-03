import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class P05Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = reader.readLine().split("[?.! ,]+");
        Set<String> sortedPalindromes = new TreeSet<>();

        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i])) {
                sortedPalindromes.add(words[i]);
            }
        }

        System.out.println(sortedPalindromes);

        //main ends here
    }

    static boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

}
