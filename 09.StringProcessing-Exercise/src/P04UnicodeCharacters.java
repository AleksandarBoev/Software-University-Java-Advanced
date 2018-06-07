import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        StringBuilder sb = new StringBuilder(input.length() * 6);

        for (int i = 0; i < input.length(); i++) {
            sb.append(getUnicodeLiteral(input.charAt(i)));
        }

        System.out.println(sb);

        //main ends here
    }

    static String getUnicodeLiteral(char character) {
        return String.format("\\u%4s", Integer.toHexString(character)).replaceAll(" ", "0");
    }

}
