import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class P06MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //case: check if a word is an empty string
        String[] words = reader.readLine().split(" ");
        String word1 = words[0];
        String word2 = words[1];

        Set<Character> word1Distinct = new LinkedHashSet<>();
        for (int i = 0; i < word1.length(); i++) {
            word1Distinct.add(word1.charAt(i));
        }

        Set<Character> word2Distinct = new LinkedHashSet<>();
        for (int i = 0; i < word2.length(); i++) {
            word2Distinct.add(word2.charAt(i));
        }

        if (word1Distinct.size() == word2Distinct.size()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        //main ends here
    }

}
