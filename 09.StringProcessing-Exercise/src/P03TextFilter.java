import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] bannedWords = reader.readLine().split(", ");
        String text = reader.readLine();

        for (int i = 0; i < bannedWords.length; i++) {
            text = text.replaceAll(bannedWords[i], buildString(bannedWords[i].length(), '*'));
        }

        System.out.println(text);
        //main ends here
    }

    static String buildString(int count, char character) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
        return sb.toString();
    }

}
