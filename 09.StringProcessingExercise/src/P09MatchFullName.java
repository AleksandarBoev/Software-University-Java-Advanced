import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(\\b[A-Z][a-z]+\\b) \\b[A-Z][a-z]+\\b");
        Matcher matcher;

        while (true) {
            String currentInput = reader.readLine();
            if ("end".equals(currentInput)) {
                break;
            }

            matcher = pattern.matcher(currentInput);
            if (matcher.matches()) {
                System.out.println(currentInput);
            }
        }

        //main ends here
    }
}
